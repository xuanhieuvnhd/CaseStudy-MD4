//Hiển thị danh sách môn học
successHandler()
function successHandler() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/subject/list",
        success: function (data) {
            let content =
                `<tr>
   
                        <td>Name</td>
                    </tr>`;
                for (let i = 0; i < data.length; i++) {
                    content += getSubject(data[i]);
                }
                document.getElementById("subjectList").innerHTML = content;
            }
    })
}
function getSubject(subject){
    return `<tr><td>${subject.name}</td></tr>`
}

//Thêm môn học mới
function displayFormCreate() {
    event.preventDefault();
    document.getElementById("form-register").reset()
    document.getElementById("form-button-submit").onclick = function () {
        addNewSubject();
    }
}
    function addNewSubject() {
        event.preventDefault();
        //Lấy dữ liệu
        let name = $("#subject").val();
        let newSubject = {
            name: name
        };
        // Gọi Ajax
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newSubject),
            //tên API
            url: "http://localhost:8080/subject/create",
            //xử lý khi thành công
            success: console.log("ok")

        });
    }
