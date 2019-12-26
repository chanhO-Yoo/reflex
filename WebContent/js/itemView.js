//스크롤 관련 변수들
let didScroll; //스크롤 했는지 여부
let lastScrollTop = 0; //
let delta = 5; //
let viewHeight;
$(()=>{
    //스크롤관련
    viewHeight = document.querySelector("#view-wrapper").scrollHeight-110;

    $(window).scroll(()=>{
        didScroll = true;
    });

    setInterval(function(){
        if(didScroll){
            hasScrolled();
            didScroll = false;
        }
    }, 250);

    //현재 선택된 탭이 상품Q&A이면 펼치기 함수 적용
    $(".qna-view").hide();
    if($("#details-qna").hasClass('active')){
        viewAnswer();
    }

}); 

function hasScrolled(){
    let cp = $(this).scrollTop(); //현재 스크롤 위치

    //delta값보다 스크롤이 더 많이 되었는가
    if(Math.abs(lastScrollTop-cp)<=delta)
        return;

    //헤더높이보다 더 스크롤이 되었는가
    if(cp>lastScrollTop && cp>viewHeight){
        //스크롤다운
        $('#opt-header').addClass('nav-up');
    }
    else{
        //스크롤업
        // if(cp+$(window).height()<$(document).height()){
            $('#opt-header').removeClass('nav-up');
        // }
    }

    lastScrollTop = cp;
}

//하단 탭 누르면 내용 보이기
function showContent(btn, sectionId){
    let sectionArr = document.querySelectorAll(".dc-inner>section");
    let btnArr = document.querySelectorAll(".details-tab button");

    for(let i in sectionArr){
        let section = sectionArr[i];
        let button = btnArr[i];

        button.style.backgroundColor = 'white';

        if(section.id===sectionId){
            $(sectionArr).removeClass('active');
            $(section).addClass('active');
        }
        if(button===btn)
            button.style.backgroundColor = '#aaaaac';
    }
}

//상품Q&A 펼치기
function viewAnswer(){
    $(".qna-header").on("click", function(){
        $(this).next().slideToggle();   
        var $header = $(this);

        $(".qna-header").next().each(function(){
            console.log("each의 콜백함수 안: ", this); //p

            //현재 요소 p가 클릭한 div의 다음 p냐? 
            if($(this).is($header.next())){
                // $(this).slideToggle();
                $(this).slideDown();
            }
            else{
                $(this).slideUp();
            }
        });
    });
}

