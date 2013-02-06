# codec

A tiny Clojure library for encoding and decoding of numbers using base-62 as basis.
Tough, the library is written in a generic way so it's pretty easy to extend with
other bases if so desired.

## Usage

```clojure
    (encode-base62 20154)

    ;;=> "fpe"

    (decode-base62 "fpe")

    ;;=> 20154
```
## License

Copyright © 2013 Kristian F. Hansen

Distributed under the Eclipse Public License, the same as Clojure.
