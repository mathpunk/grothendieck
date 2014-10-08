(ns grothendieck.server
  (:require [org.httpkit.server :refer [run-server]]))

; I are a server
(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})



; ============================================================================= 
; Serving Chapters & Other Pages
; ============================================================================= 
; STATIC
; Create a public html directory.
; It's got resources probably.
; But most importantly, it has pages, with names. 
; That's what you're after, after all. 
; - How does http-kit serve static routes? 

; Test: 
; When you start the directory, does it serve your pages? 
; To test this, you need, 
; - a sample.html file in the test/public directory


; ============================================================================= 
; Creating exclusivity
; ============================================================================= 
; Does the chapter dir have htaccess? 
; Do the users have their passwords? 



; ============================================================================= 
; Dynamic Services
; ============================================================================= 
; 
; What do you want to route? 
; - notes (i have some)
; - art (for making and soliciting art)
; - share (for music)
;
; getdenizen services? 
; - to charge for money
; - to freshen up the access implementation
;
;
; ----------------------------------------------------------------------------- 
; Notes Server
; ----------------------------------------------------------------------------- 
; en: mongo connection
; pin: api connection
; cards: fs connection


; ============================================================================= 
; MAIN
; ============================================================================= 
(run-server app {:port 8080})
