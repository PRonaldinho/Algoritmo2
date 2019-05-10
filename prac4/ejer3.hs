------------------------------------------------------------------------------
--- EJERCICIO 3 ---
minMax :: [Int] -> (Int,Int)
minMax [] = (maxBound,minBound)
minMax (x:xs)= (min x a,max x b)
			where (a,b) = minMax xs

------------------------------------------------------------------------------
--- EJERCICIO 4 ---
maxi :: [Int] -> Int
maxi xs = snd (minMax xs)

mayorInd :: [Int] -> Int
mayorInd xs = mayor 0 (maxi xs) xs   

mayorInd2 :: Int -> [Int] -> Int
mayorInd2 _ [] = 0
mayorInd2 n (x:xs) | x == n = 
			   	     | otherwise = mayorInd2 (n+1) (tail xs)
