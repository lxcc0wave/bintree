/**
 * Contains a parser for the following language.<br>
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
package parser;