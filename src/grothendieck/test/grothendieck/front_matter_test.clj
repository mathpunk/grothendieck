(ns grothendieck.front-matter-test
  (:require [expectations :refer [expect]])
  (:require [grothendieck.front-matter :refer [process-lines]]))

;; A test.
(def test-lines
  ["---"
   "key1: value1"
   "key2: value2"
   "---"
   ""
   "Body text paragraph 1"
   ""
   "Body text paragraph 2"
   ""
   "Body text paragraph 3"])

;; Calling our function now:

(expect (process-lines test-lines)
        {:front ("key1: value1" "key2: value2"),
         :body ("Body text paragraph 1"
                      "Body text paragraph 2"
                      "Body text paragraph 3")})
