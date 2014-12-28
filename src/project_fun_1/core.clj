(ns project-fun-1.core)

(defn adj
  "To adjust values of adjacent candy"
  [x y]
  (if (odd? (/ (+ x y) 2)) (+ (/ (+ x y) 2) 1) (/ (+ x y) 2)))  ; Check weather adjusted value is odd or not

(defn v 
  "To distruct vector and manipulate indivial candy"
  [candy]
  (let [[c1 c2 c3 c4] candy]
    (def candyADJ [(adj c1 c2) (adj c2 c3) (adj c3 c1) (+ c4 1)]))
  candyADJ)

(defn candy-loop
  "Loop and recur to count turn"
  [candy]
  (loop [result [] candy candy]
    (if (= (candy 0) (candy 1) (candy 2))
      (conj result candy)
      (recur (conj result candy) (v candy)))))

(defn candy-read
  "Read candy from user"
  []
  (candy-loop [(read) (read) (read) 0]))