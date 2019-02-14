(defproject cljs-tg-login-btn "0.1.0-SNAPSHOT"
  :description "Telegram login button for ClojureScript Reagent users"
  :url "https://github.com/evilsneer/cljs-tg-login-btn"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"
                  :scope "provided"]
                 [reagent "0.8.1"]
                 [cljs-add-script "0.1.0-SNAPSHOT"]]
  :repl-options {:init-ns cljs-tg-login-btn.core})
