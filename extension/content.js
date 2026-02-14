function checkSolved() {
    const resultElement = document.querySelector(".result-text");
    if (!resultElement) return;

    if (!resultElement.innerText.includes("맞았습니다")) return;

    const userId =
        document.querySelector(".username")?.innerText || "unknown";

    const params = new URLSearchParams(window.location.search);
    const problemNumber = parseInt(params.get("problem_id"));

    if (!problemNumber) {
        console.error("문제 번호 추출 실패");
        return;
    }

    const solvedData = {
        userId,
        problemNumber,
        solvedAt: new Date().toISOString()
    };

    fetch("http://localhost:8080/api/solved", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(solvedData)
    })
    .then(res => {
        if (!res.ok) {
            return res.text().then(t => {
                throw new Error(t);
            });
        }
        console.log("전송 성공");
    })
    .catch(err => {
        console.error("전송 실패", err.message);
    });
}

window.addEventListener("load", () => {
    setTimeout(checkSolved, 1000);
});
