#### Modulo - Remainder after division
---

**Modulo Operation**

```javascript
    mod = number % n
```
- It will range from `0 <= m <= n-1` for positive numbers.
- We take Modulo of `10^9 + 7` number.
  -  It is large.
  -  It is prime

**Modulo Airthmetic**
```javascript
(a+b)%c = ((a%c) + (b%c))%c
```
```javascript
(a-b)%c = ((a%c) - (b%c))%c
```
```javascript
(a*b)%c = ((a%c) * (b%c))%c
```
```javascript
(a/b)%c = ((a%c) / (b%c))%c #if multiplicative inverse exist
```

For negative numbers we need to do below 

`a % m` is giving negative number
then,

```javascript
((a % m) + m)%m = will range in 0 - (n-1)
```

