(ns grothendieck.server
  (:require [org.httpkit.server :refer [run-server]]))

; [x] HELLO WORLD
(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(run-server app {:port 8080})



; STATIC
; ensure that static pages are served from directories

; ensure that chapter dir has htaccess
; later,
; ensure that chapter dir is an authenticated path

; ensure that reverse proxies are go (?)

; DYNAMIC
; learn about routes and shit
