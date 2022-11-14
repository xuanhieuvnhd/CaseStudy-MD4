let token = localStorage.getItem("token");
function addNewStory(){
    let content =$('#content').val();
    let teacher=$('#teacher').val()
    // let classRoom=$('#classroom').val()
    let newStories ={
        content: content,
        // classRoom:classRoom,
        user:localStorage.getItem(teacher)
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        BeforeSend: function (xhr) {
            xhr.setRequestHeader ("Authorization", "Bearer " + token);
        },
        type: "POST",
        data: JSON.stringify(newStories),
        url: "http://localhost:8080/stories/create",
        success:tabStory

    });
}
function  backHome(){
    window.location.href="teacher.html"
}
function tabStory(){
    let content="Add Success"
    document.getElementById('success').innerHTML=content;
}