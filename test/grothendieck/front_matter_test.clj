(ns grothendieck.front-matter-test
  (:require [grothendieck.static.front-matter :refer [process-lines with-front-matter]])
  (:require [expectations :refer [expect in]]))

(def minimal-front-matter "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/title are cool.wiki")

(expect {:title "An actual title, given by me"} (in (with-front-matter minimal-front-matter)))

