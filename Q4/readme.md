## 2021년 4분기 (10월~12월)

```kotlin
fun main() {
//    ### 👀 [1710](https://leetcode.com/problemset/all/?search=1710&page=1)
    val start = 1718

    for (i in 0..7) {
        println("### \uD83D\uDC40 [${start + i}](https://leetcode.com/problemset/all/?search=${start + i}&page=1)")
        println("####\n" +
                "[solution]()\n" +
                "####")
    }
}
```

## 크롬 콘솔에서 실행하면 Easy!
```javascript
function main() {
  const start = 1718;
  let problem = "";
  
  problem +="## Week 35\n"
  for (let i=0; i<8; i++){
    problem += `### \uD83D\uDC40 [${start + i}](https://leetcode.com/problemset/all/?search=${start + i}&page=1)\n`;
    problem += "####\n[solution]()\n####\n";
  }
  
  console.log(problem);
}
main();
```

