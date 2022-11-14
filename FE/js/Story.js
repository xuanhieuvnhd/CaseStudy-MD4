
function listStories(){
    event.preventDefault();
    document.getElementById("display-story").hidden=false;

    displayStory();
}
const btn =document.getElementById("display")
btn.addEventListener('click', () =>{
    const form =document.getElementById('displayClassroom')
    if(form.style.display==='none'){
        form.style.display='block';
    }else {
        form.style.display='none';
    }
})

function displayStory(){
    $.ajax({
        type:"GET",
        url :"http://localhost:8080/stories",
        success:function (data){
            let content ='<tr>\n'+
                '<td>Content</td>\n'+
                '<td>Date</td>\n'+
                '<td>Class</td>\n' +
                '<td>Name Teacher</td>\n' +
                '</tr>';
            for (let i=0; i <data.length;i++){
                content+=getStories(data[i]);
            }
            document.getElementById('storyList').innerHTML=content;
        }
    });
}
function getStories(stories){
    return `<tr><td >${stories.content}</td><td >${stories.date}</td><td >${stories.name_class}</td><td >${stories.full_name}</td>` +
        `</tr>`;
}
