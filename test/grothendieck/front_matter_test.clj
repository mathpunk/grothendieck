(ns grothendieck.front-matter-test
  (:require [grothendieck.static.front-matter :refer :all])
  (:require [expectations :refer [expect in]])
  (:require [clojure.string :as string]))

(def test-dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content")
(def minimal-front-matter "title are cool.wiki")
(def beefier-front-matter "the first person with a head.wiki")

; Minimal
(let [minimal-front (with-front-matter (str test-dir "/" minimal-front-matter))]
  (expect {:title "An actual title, given by me"} (in minimal-front)))

; Something with body too
(let [beefy (with-front-matter (str test-dir "/" beefier-front-matter))]
  (expect {:character "Some goner, I dunno"} (in beefy))
  (expect #"goner" (:body beefy))
  beefy
  )

;;   (with-open [r (clojure.java.io/reader (str test-dir "/" beefier-front-matter))]
;;     (let [lines (process-lines (line-seq r))
;;           body (string/join " " (:body lines))]
;;       (if (:front lines)
;;            (apply assoc {} (flatten
;;                (for [string (:front data)]
;;                   (let [split (clojure.string/split string #":")
;;                         k (keyword (first split))
;;                         v (rest split)]
;;                     (assert (= (count split) 2) "grothendieck.static.front-matter
;;                                                  might be confused by a colon in a field's value.")
;;                     [k (map #(string/trim %) v)])))))))
