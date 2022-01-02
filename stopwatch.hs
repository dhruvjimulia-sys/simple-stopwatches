import Control.Concurrent

convertTime :: Int -> (Int, Int, Int)
convertTime s
  = (h, m', s')
  where (m, s') = quotRem s 60
        (h, m') = quotRem m 60

showTwoDigit :: Int -> String
showTwoDigit i
  = show q ++ show r
  where (q, r) = quotRem i 10

printCurrentTime :: Int -> IO String
printCurrentTime t
  = do
    (h, m, s) <- return $ convertTime t
    putStr (showTwoDigit h ++ ":" ++ showTwoDigit m ++ ":" ++ showTwoDigit s) 
    threadDelay (10 ^ 6)
    putStr "\ESC[2K\ESC[0G"
    printCurrentTime (t + 1)

main = do printCurrentTime 0
