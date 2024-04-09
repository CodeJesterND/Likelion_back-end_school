// 초기 할 일 목록
let basicDatas = [
    { id: 1, title: "Todo 1", done: false }, // 초기 데이터
    { id: 2, title: "Todo 2", done: true }
];

// HTML 요소 가져오기
const todoForm = document.getElementById("todoForm"); // 할 일 입력 폼
const todoInput = document.getElementById("todoInput"); // 할 일 입력 필드
const todoItemList = document.getElementById("todoItemList"); // 할 일 목록 요소

// 할 일 목록을 화면에 표시하는 함수
function displayTodos() {
    todoItemList.innerHTML = ""; // 기존 목록 초기화

    // 각 할 일 항목을 순회하며 화면에 표시
    basicDatas.forEach(todo => {
        const li = document.createElement("li");
        li.classList.add("todo-item");
        li.dataset.id = todo.id; // 데이터 세트로 할 일 ID 설정

        // 완료 체크마크 추가
        const checkMark = document.createElement("span");
        checkMark.classList.add("check-mark");
        checkMark.textContent = "✔";
        checkMark.onclick = function(event) {
            event.stopPropagation(); // 부모 요소의 클릭 이벤트 전파 방지
            toggleDone(todo.id); // 할 일 완료 상태 토글
        };

        // 할 일 텍스트 추가
        const todoText = document.createElement("span");
        todoText.classList.add("todo-text");
        todoText.textContent = todo.title;
        if (todo.done) {
            todoText.classList.add("checked"); // 완료된 할 일인 경우 텍스트에 스타일 적용
        }

        // 삭제 버튼 추가
        const removeButton = document.createElement("span");
        removeButton.textContent = "❌";
        removeButton.classList.add("remove");
        removeButton.onclick = function(event) {
            event.stopPropagation(); // 부모 요소의 클릭 이벤트 전파 방지
            deleteTodo(todo.id); // 해당 할 일 삭제
        };

        // 각 요소를 할 일 항목(li)에 추가
        li.appendChild(checkMark);
        li.appendChild(todoText);
        li.appendChild(removeButton);
        todoItemList.appendChild(li); // 할 일 항목을 목록에 추가
    });
}

// 새로운 할 일 추가 함수
function addTodo() {
    const todoText = todoInput.value.trim(); // 입력된 할 일 텍스트
    if (todoText === "") {
        alert("Please enter a todo!"); // 빈 할 일은 추가하지 않고 알림 표시
        return;
    }

    // 새로운 할 일 객체 생성
    const newTodo = {
        id: basicDatas.length > 0 ? Math.max(...basicDatas.map(todo => todo.id)) + 1 : 1, // 새로운 할 일 ID 설정
        title: todoText, // 할 일 제목 설정
        done: false // 완료 여부 초기값 설정
    };

    basicDatas.push(newTodo); // 새로운 할 일을 배열에 추가
    displayTodos(); // 변경된 할 일 목록을 다시 표시
    todoInput.value = ""; // 입력 필드 초기화
}

// 할 일 삭제 함수
function deleteTodo(id) {
    basicDatas = basicDatas.filter(todo => todo.id !== id); // 해당 ID를 가진 할 일 삭제
    displayTodos(); // 변경된 할 일 목록을 다시 표시
}

// 할 일 완료 상태 토글 함수
function toggleDone(id) {
    const todo = basicDatas.find(todo => todo.id === id); // 해당 ID를 가진 할 일 찾기
    todo.done = !todo.done; // 완료 상태 토글
    displayTodos(); // 변경된 할 일 목록을 다시 표시
}

// 폼 제출 시 할 일 추가 이벤트 리스너
todoForm.addEventListener("submit", function(event) {
    event.preventDefault(); // 폼 제출 기본 동작 방지
    addTodo(); // 할 일 추가 함수 호출
});

// 엔터 키 입력 시 할 일 추가 이벤트 리스너
todoInput.addEventListener("keydown", function(event) {
    if (event.key === "Enter" || event.keyCode === 13) {
        event.preventDefault(); // 엔터 키 기본 동작 방지
        addTodo(); // 할 일 추가 함수 호출
    }
});

// 페이지 로드 시 초기 할 일 목록 표시
displayTodos();