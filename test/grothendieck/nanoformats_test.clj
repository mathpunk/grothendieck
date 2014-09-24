(ns grothendieck.nanoformats-test
  (:require [grothendieck.nanoformats :refer :all])
  (:require [clojure.test :refer [is]]))

(is (sub-links "This has a [[link]].") ["link"])
(is (empty? (sub-links "This has no link.")) true)
