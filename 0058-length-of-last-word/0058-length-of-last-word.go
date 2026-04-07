import(
    "strings"
)

func lengthOfLastWord(s string) int {
    //트리밍
    s = strings.TrimSpace(s)
    //단어 분리
    words:= strings.Split(s, " ");
    //마지막 단어 추출하기
    lastword:= words[len(words) - 1]
    //마지막 단어의 글자 수 세기
    return len(lastword)
}