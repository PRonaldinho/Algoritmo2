------------------------ Ejercicio 1) a) --------------------------------
permu :: [a] -> [[a]]
permu [] = [[]]
permu (x:xs) = concat (map (inter x) (permu xs))

inter :: a -> [a] -> [[a]]
inter x [] = [[x]]
inter x (y:ys) = (x:y:ys): (map (\t-> y:t) (inter x ys))

----------------------- Ejercicio 1) b) -----------------------------------
subConj :: [a] -> [[a]]
subConj [] = [[]]
subConj (x:xs) = [ x:y | y <- subConj xs ] ++ subConj xs 

subConj2 :: [a] -> [[a]]
subConj2 [] = [[]]
subConj2 (x:xs) = (subConj2 xs) ++ (map (\xs-> x:xs) (subConj2 xs))

----------------------------- Ejercicio 1) c) -----------------------------------
subLista :: [a] -> [[a]]
subLista [] = [[]] --FALTA
subLista xs = subConj xs ++ subLista (tail xs) 

--------------------------------- Ejercicio 3 -----------------------------------
slowSort :: (Ord a) => [a] -> [a] 
slowSort xs = ve (permu xs)

ve :: (Ord a) => [[a]] -> [a] 
ve xs = head (filter ordenado xs)

ordenado :: (Ord a) => [a] -> Bool
ordenado [] = True
ordenado [x] = True
ordenado (x:y:xs)= x<=y && ordenado (y:xs)


