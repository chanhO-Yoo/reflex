document.addEventListener('DOMContentLoaded', function(){
    toggleSideMenuLevel1();
    toggleSideMenuLevel2();
});

function toggleSideMenuLevel1(){
    var btnSideMenu = document.querySelector('#btn-sidemenu');
    var level1SideMenu = document.querySelector('#level1-sidemenu');
    var sideMenuList = document.querySelectorAll('.sidemenu-wrapper');

    btnSideMenu.addEventListener('click', function(){
        sideMenuList.forEach(function(sMenu){
            var bool = sMenu.classList.contains('show-sidemenu');
            //레벨1인 경우 그냥 열고 닫기. 
            if(sMenu.id === 'level1-sidemenu'){
                sMenu.classList.toggle('show-sidemenu');
            }
            //레벨2 이상 메뉴가 열려있는 경우
            if(sMenu.id !== 'level1-sidemenu' && sMenu.classList.contains('show-sidemenu')){
                level1SideMenu.classList.remove('show-sidemenu');
                sMenu.classList.remove('show-sidemenu');
            }
        });
    });
}

function toggleSideMenuLevel2(){
    var level1SideMenu = document.querySelector('#level1-sidemenu');
    var level1MenuLi = document.querySelectorAll('#level1-sidemenu li');

    // for(var i in level1MenuLi){
        level1MenuLi[0].addEventListener('click', function(){
            console.log(level1MenuLi[0].id);
            var level2Menu = document.querySelector('#level2-'+level1MenuLi[0].id);
            level2Menu.classList.add('show-sidemenu');

        });
    // }
}

