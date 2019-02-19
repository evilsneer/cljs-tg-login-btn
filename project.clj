(defproject cljs-tg-login-btn "0.1.0"
  :description "Telegram login button for ClojureScript Reagent users"
  :url "https://github.com/evilsneer/cljs-tg-login-btn"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"
                  :scope "provided"]
                 [reagent "0.8.1"]
                 [cljs-add-script "0.1.1"]]
  :repl-options {:init-ns cljs-tg-login-btn.core}

  ;:aliases {"test" ^{:doc "Clean and Test"}
  ;                 ["do" "clean" ["with-profile" "dev" "doo" "phantom" "test" "once"]]}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
