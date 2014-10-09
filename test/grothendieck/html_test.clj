(ns grothendieck.html-test
  (:require [expectations :refer :all])
  (:use [grothendieck.static.html :refer :all]))


; Slugs
(expect "i-am-page.html" (slug "i am page.md"))
(expect "i-am-page.html" (slug "i am page.wiki"))
(expect "i-am-page.html" (slug "i am page.my"))
