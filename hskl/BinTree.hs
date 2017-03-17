module BinTree where

-- interface BinTree, class implementing this
data BinTree a = 
     Add (BinTree a) (BinTree a) |
     Multiply (BinTree a) (BinTree a) |
     Abs (BinTree a) |
     Factorial (BinTree a) |
     Minus (BinTree a) |
     Data a deriving Show

-- evaluate BinTree as syntax tree
evalBinTree :: BinTree Int -> Int
evalBinTree (Add l r)      = evalBinTree l + evalBinTree r
evalBinTree (Multiply l r) = evalBinTree l * evalBinTree r
evalBinTree (Abs x)        | evalBinTree x > 0     = evalBinTree x
                           | otherwise             = - evalBinTree x
evalBinTree (Factorial x)  = g (evalBinTree x) 1
  where
    g n acc | n <= 0    = acc
            | otherwise = g (n - 1) (acc * n)
evalBinTree (Minus x)      = - evalBinTree x
evalBinTree (Data x)       = x

-- print BinTree in pre-order
dumpBinTree :: Show a => BinTree a -> String
dumpBinTree tree = dump tree 0
  where
    dump (Add l r) n          = indent n ++ "Add\n" ++ dump l (n + 1) ++ dump r (n + 1)
    dump (Multiply l r) n     = indent n ++ "Multiply\n" ++ dump l (n + 1) ++ dump r (n + 1)
    dump (Abs x) n            = indent n ++ "Abs\n" ++ dump x (n + 1)
    dump (Factorial x) n      = indent n ++ "Factorial\n" ++ dump x (n + 1)
    dump (Minus x) n          = indent n ++ "Minus\n" ++ dump x (n + 1)
    dump (Data x) n           = indent n ++ "Data[" ++ show x ++ "]\n"
    indent = makeIndent "  "

makeIndent :: String -> Int -> String
makeIndent tab n = g tab n ""
  where
    g tab n acc | n <= 0    = acc
                | otherwise = g tab (n - 1) (tab ++ acc)