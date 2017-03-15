package parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import tree.Abs;
import tree.Add;
import tree.Data;
import tree.Factorial;
import tree.Minus;
import tree.Multiply;
import tree.Node;

/**
 * Parser for following language.<br>
 *
 * Lang ::= Exp "."<br>
 * Exp ::= E1 ("+" E1)*<br>
 * E1 ::= E2 ("*" E2)*<br>
 * E2 ::= "-"* E3<br>
 * E3 ::= E4 "!"?<br>
 * E4 ::= int | "|" Exp "|" | "(" Exp ")"
 *
 * @author lxcc0wave
 * @version 2017.3.15
 */
public class NodeParser {
	private BufferedReader br;
	/**
	 * Target character.
	 */
	private char currChar;
	/**
	 * {@link currToken}'s value.
	 */
	private int tokenValue;
	/**
	 * Target token.
	 */
	private Token currToken;
	/**
	 * If {@code true} then suspend {@link NodeParser#nextChar()}.
	 */
	private boolean wait;
	/**
	 * If {@code true} then print lexical anlysis.
	 */
	public  boolean printLex;
	/**
	 * Constructs a parser with the specified input stream.
	 * @param in InputStream
	 */
	public NodeParser(InputStream in){
		br = new BufferedReader(new InputStreamReader(in));
		currChar = '\0';
		tokenValue = Integer.MIN_VALUE;
		currToken = Token.START;
		wait = false;
		printLex = false;
	}
	/**
	 * Constructs a parser with the specified input string.
	 * @param in String
	 * @throws UnsupportedEncodingException never thrown
	 */
	public NodeParser(String in) throws UnsupportedEncodingException{
		br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(in.getBytes("UTF-8"))));
		currChar = '\0';
		tokenValue = Integer.MIN_VALUE;
		currToken = Token.START;
		wait = false;
		printLex = false;
	}
	/**
	 * Parse input that ends with period.
	 * @return Node
	 * @throws IOException If an I/O error occurs
	 * @throws NodeParserException Syntax error,...
	 */
	public Node parse() throws IOException, NodeParserException{
		nextToken();
		Node result = Exp();
		if(currToken != Token.END)
			throw new NodeParserException("Input string ends while parsing");
		return result;
	}

	/**
	 * Read next character from input stream.
	 * @throws IOException If an I/O error occurs
	 */
	private void nextChar() throws IOException{
		if(wait){
			wait = false;
		} else {
			currChar = (char)br.read();
		}
	}
	/**
	 * ungetChar.
	 */
	private void rewind(){
		wait = true;
	}
	/**
	 * Read next token from input stream.
	 *
	 * @throws IOException If an I/O error occurs
	 * @throws NodeParserException If an unknown token is read.
	 */
	private void nextToken() throws IOException, NodeParserException {
		do{
			nextChar();
		} while (Character.isWhitespace(currChar));

		switch(currChar){
		case '+':
			currToken = Token.PLUS;
			break;
		case '-':
			currToken = Token.MINUS;
			break;
		case '*':
			currToken = Token.AST;
			break;
		case '!':
			currToken = Token.EXCL;
			break;
		case '|':
			currToken = Token.VERT;
			break;
		case '(':
			currToken = Token.LPAR;
			break;
		case ')':
			currToken = Token.RPAR;
			break;
		case '.':
			currToken = Token.END;
			break;
		default:
			if(Character.isDigit(currChar)){
				currToken = Token.NUMBER;
				readNumber();
			} else {
				throw new NodeParserException("Character : " + currChar + " : is invalid.");
			}
		}
		// lex result
		if(printLex){
			System.out.println("nextToken():Token=" + currToken + ", Value=" + tokenValue);
		}
	}
	/**
	 * Read value of {@code Token.Number}.
	 *
	 * @throws IOException If an I/O error occurs
	 */
	private void readNumber() throws IOException{
		String acc = "" + currChar;
		while(true){
			nextChar();
			if(!Character.isDigit(currChar))
				break;
			acc += currChar;
		}
		rewind();
		tokenValue = Integer.parseInt(acc);
	}

	/**
	 * Exp ::= E1 ("+" E1)*
	 * @return AST
	 * @throws NodeParserException Syntax error,...
	 * @throws IOException If an I/O error occurs
	 */
	private Node Exp() throws IOException, NodeParserException{
		Node x = E1();
		while(currToken == Token.PLUS){
			nextToken();
			x = new Add(x, E1());
		}
		return x;
	}
	/**
	 * E1 ::= E2 ("*" E2)
	 * @return AST
	 * @throws NodeParserException Syntax error,...
	 * @throws IOException If an I/O error occurs
	 */
	private Node E1() throws IOException, NodeParserException{
		Node x = E2();
		while(currToken == Token.AST){
			nextToken();
			x = new Multiply(x, E2());
		}
		return x;
	}
	/**
	 * E2 ::= "-"* E3
	 * @return AST
	 * @throws NodeParserException Syntax error,...
	 * @throws IOException If an I/O error occurs
	 */
	private Node E2() throws IOException, NodeParserException{
		int count = 0;
		while(currToken == Token.MINUS){
			count++;
			nextToken();
		}
		Node x = E3();
		for(int i = 0; i < count; i++)
			x = new Minus(x);
		return x;
	}
	/**
	 * E3 ::= E4 "!"?
	 * @return AST
	 * @throws NodeParserException Syntax error,...
	 * @throws IOException If an I/O error occurs
	 */
	private Node E3() throws IOException, NodeParserException{
		Node x = E4();
		if(currToken == Token.EXCL){
			nextToken();
			x = new Factorial(x);
		}
		return x;
	}
	/**
	 * E4 ::= int | "|" Exp "|" | "(" Exp ")"
	 * @return AST
	 * @throws NodeParserException Not matching paren, verts,...
	 * @throws IOException If an I/O error occurs
	 */
	private Node E4() throws IOException, NodeParserException{
		if(currToken == Token.NUMBER){
			int v = tokenValue;
			nextToken();
			return new Data(v);
		}
		if(currToken == Token.VERT){
			nextToken();
			Node x = Exp();
			if(currToken != Token.VERT)
				throw new NodeParserException("Not matching verts.");
			nextToken();
			return new Abs(x);
		}
		if(currToken == Token.LPAR){
			nextToken();
			Node x = Exp();
			if(currToken != Token.RPAR)
				throw new NodeParserException("Not matching paren.");
			nextToken();
			return x;
		}
		throw new NodeParserException("Syntax error.");
	}
}
