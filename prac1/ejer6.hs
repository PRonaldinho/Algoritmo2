anagrama :: [Char] -> [Char] -> Bool
anagrama [] [] = True
anagrama [] ys = True 
anagrama xs [] = False
anagrama (x:xs) ys | pert x ys = anagrama xs (borrar x ys)
				   | otherwise = False

pert :: Char -> [Char] -> Bool
pert x [] = False
pert x (y:ys) | x==y = True
			  | otherwise = pert x ys

borrar :: Char -> [Char] -> [Char]
borrar x [] = []
borrar x (y:ys) | x==y = ys
		   	    | otherwise = y: borrar x ys






