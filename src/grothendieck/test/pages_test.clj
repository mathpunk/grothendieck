(ns grothendieck.test.pages-test
  (:require [expectations :refer [expect])
  (:use [grothendieck.pages :refer :all]))

(let [site "test/test-site"
      index (make-index site)]
  (expect #"<html><body>.*</body></html>" index)
  (expect #"<div id=\"text\">" index)
  )

