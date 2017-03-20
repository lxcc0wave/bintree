#include<stdio.h>
#include<stdlib.h>

/* node type */
typedef enum {
  ADD, MULTIPLY, ABS, FACTORIAL, MINUS, DATA
} TAG;
/* node structure */
typedef struct tree {
  TAG tag;
  int value;
  struct tree* left;
  struct tree* right;
} tree;
/* for dump */
const char* TAB = "  ";
/* constructor of tree */
tree* make_tree(tree* left, tree* right, TAG tag, int value);
/* dispose tree */
void free_tree(tree* t);
/* 
constructor of ADD node
left, right : NOT NULL
 */
tree* make_add(tree* left, tree* right);
/*
constructor of MULTIPLY node
left, right : NOT NULL
*/
tree* make_multiply(tree* left, tree* right);
/*
constructor of ABS node
arg : NOT NULL
*/
tree* make_abs(tree* arg);
/*
constructor of FACTORIAL node
arg : NOT NULL
*/
tree* make_factorial(tree* arg);
/*
constructor of MINUS node
arg : NOT NULL
*/
tree* make_minus(tree* arg);
/*
constructor of DATA node
*/
tree* make_data(int value);
/* evaluate tree as syntax tree */
int eval_tree(tree* t);

void _dump_tree(tree* t, int indent);
/* print tree in pre-order */
void dump_tree(tree* t){
  _dump_tree(t, 0);
}

void error(char* message){
  fprintf(stderr, "%s\n", message);
  exit(1);
}

int main(){
  tree* root = make_add(
			make_minus( make_factorial( make_data(4) ) ),
			make_multiply(
				      make_data(10),
				      make_abs( make_minus( make_data(4) ) )
				      )
			);
  printf("DUMP:\n");
  dump_tree(root);
  printf("EVAL:\n");
  printf("%d\n", eval_tree(root));
  free_tree(root);
  return 0;
}

tree* make_tree(tree* left, tree* right, TAG tag, int value){
  tree* t = (tree*)malloc(sizeof(tree));
  if(t == NULL){
    error("tree malloc failure");
  }
  t->left = left;
  t->right = right;
  t->tag = tag;
  t->value = value;
  return t;
}
void free_tree(tree* t){
  if(t == NULL)
    return;
  free_tree(t->left);
  free_tree(t->right);
  free(t);
}

tree* make_add(tree* left, tree* right){
  return make_tree(left, right, ADD, 0);
}
tree* make_multiply(tree* left, tree* right){
  return make_tree(left, right, MULTIPLY, 0);
}
tree* make_abs(tree* arg){
  return make_tree(arg, NULL, ABS, 0);
}
tree* make_factorial(tree* arg){
  return make_tree(arg, NULL, FACTORIAL, 0);
}
tree* make_minus(tree* arg){
  return make_tree(arg, NULL, MINUS, 0);
}
tree* make_data(int value){
  return make_tree(NULL, NULL, DATA, value);
}

int eval_add(tree* t);
int eval_multiply(tree* t);
int eval_abs(tree* t);
int eval_factorial(tree* t);
int eval_minus(tree* t);
int eval_data(tree* t);

int eval_tree(tree* t){
  if(t == NULL)
    return 0;
  switch(t->tag){
  case ADD:
    return eval_add(t);
  case MULTIPLY:
    return eval_multiply(t);
  case ABS:
    return eval_abs(t);
  case FACTORIAL:
    return eval_factorial(t);
  case MINUS:
    return eval_minus(t);
  case DATA:
    return eval_data(t);
  default:
    error("eval : can't evaluate tag");
    return 0;
  }
}

int factorial(int n);
int abs(int n);

int eval_add(tree* t){
  return eval_tree(t->left) + eval_tree(t->right);
}
int eval_multiply(tree* t){
  return eval_tree(t->left) * eval_tree(t->right);
}
int eval_abs(tree* t){
  return abs(eval_tree(t->left));
}
int eval_factorial(tree* t){
  return factorial(eval_tree(t->left));
}
int eval_minus(tree* t){
  return - eval_tree(t->left);
}
int eval_data(tree* t){
  return t->value;
}

int abs(int n){
  return n > 0 ? n : -n;
}
int _factorial(int n, int acc){
  return n <= 0 ? acc : _factorial(n-1, n * acc);
}
int factorial(int n){
  return _factorial(n, 1);
}

void dump_add(tree* t, int indent);
void dump_multiply(tree* t, int indent);
void dump_abs(tree* t, int indent);
void dump_factorial(tree* t, int indent);
void dump_minus(tree* t, int indent);
void dump_data(tree* t, int indent);

void _dump_tree(tree* t, int indent){
  if(t == NULL)
    return;
  switch(t->tag){
  case ADD:
    dump_add(t, indent);
    return;
  case MULTIPLY:
    dump_multiply(t, indent);
    return;
  case ABS:
    dump_abs(t, indent);
    return;
  case FACTORIAL:
    dump_factorial(t, indent);
    return;
  case MINUS:
    dump_minus(t, indent);
    return;
  case DATA:
    dump_data(t, indent);
    return;
  default:
    error("dump : can't evaluate tag");
  }
}

void make_indent(int n);

void dump_add(tree* t, int indent){
  make_indent(indent);
  printf("ADD\n");
  _dump_tree(t->left, indent + 1);
  _dump_tree(t->right, indent + 1);
}
void dump_multiply(tree* t, int indent){
  make_indent(indent);
  printf("MULTIPLY\n");
  _dump_tree(t->left, indent + 1);
  _dump_tree(t->right, indent + 1);
}
void dump_abs(tree* t, int indent){
  make_indent(indent);
  printf("ABS\n");
  _dump_tree(t->left, indent + 1);
}
void dump_factorial(tree* t, int indent){
  make_indent(indent);
  printf("FACTORIAL\n");
  _dump_tree(t->left, indent + 1);
}
void dump_minus(tree* t, int indent){
  make_indent(indent);
  printf("MINUS\n");
  _dump_tree(t->left, indent + 1);
}
void dump_data(tree* t, int indent){
  make_indent(indent);
  printf("DATA[%d]\n", t->value);
}

void make_indent(int n){
  int i;
  for(i = 0; i < n; i++)
    printf("%s", TAB);
}
