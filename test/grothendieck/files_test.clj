(ns grothendieck.files-test
  (:require [expectations :refer :all])
  (:use [grothendieck.files :refer :all]))


; ===========================================================================
;  Helpers
; ===========================================================================
;
; title->slug
; ---------------------------------------------------------------------------
; Turns arbitrary filenames 'n titles into friendly slugs.
(expect "i-am-page.html" (title->slug "i am page.md"))
(expect "i-am-page.html" (title->slug "i am page.wiki"))
(expect "i-am-page.html" (title->slug "i am page.my"))
; It's not all that safe--
; FAILS: (expect "i-am-page.html" (title->slug "I Am Page!"))
(expect "compiled-domains-of-mathematics" (title->slug "Compiled Domains of Mathematics"))
