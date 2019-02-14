(defproject cljs-tg-login-btn "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-git-deps "0.0.1-SNAPSHOT"]]
  :git-dependencies [["https://github.com/evilsneer/cljs-add-script.git" "8dd3c9ea165af4bdd43fa9d1c01e18c017ab5192"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [reagent "0.8.1"]]
  :repl-options {:init-ns cljs-tg-login-btn.core})
