# cljs-tg-login-btn

[![Clojars Project](https://img.shields.io/clojars/v/cljs-tg-login-btn.svg)](https://clojars.org/cljs-tg-login-btn)

A Clojure library designed to provide Telegram login button for ClojureScript Reagent users

## Usage

```clojure
(ns app.core
  (:require [cljs-tg-login-btn.core :refer [telegram-btn]]))

; callback function 
;; login is written somewhere else
(defn ^:export onTelegramAuth [user]
  (let [username (.-username user)
        id (.-id user)]
    (login username)))
    
; tg-login-avalible turns true when telegram button will be successfully loaded
(defn page []
  (let [tg-login-avalible (atom false)]
    (fn []
      [:div.bs-component
       [:div {:hidden (not @tg-login-avalible)}
         [telegram-btn tg-login-avalible "app.core.onTelegramAuth"]]])))
         
;and blabla reagent render stuff
```

## License

Copyright © 2019 Vladislav Shishkov

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
