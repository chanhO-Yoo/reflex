document.addEventListener('DOMContentLoaded', function(){
	calShipItemPrice(); //배송비, 상품금액 계산
	usePoint(); //포인트 계산
}); 
function usePoint(){
	//포인트관련 변수
	let memberHavePoint = document.querySelector("#memberHavePoint").innerText;
	memberHavePoint = memberHavePoint.replace(",", "").replace("원", "")*1;
	let inputPoint = document.querySelector("#inputPoint"); //결제금액 사용포인트 입력태그
	let btnUseAll = document.querySelector("#btn-useAll"); //전액사용버튼
	let showUsePoint = document.querySelector("#showUsePoint"); //결제금액 사용포인트란
	let userPoint = document.querySelector("#userPoint"); //최종결제금액 포인트사용란
	
	//최종결제금액 변수
	let userItemPrice = document.querySelector("#userItemPrice").innerText; //주문상품
	let userShipPrice = document.querySelector("#userShipPrice").innerText; //배송비
	let userTotalPrice = document.querySelector("#userTotalPrice"); //총 결제금액
	userItemPrice = userItemPrice.replace(",","")*1;
	userShipPrice = userShipPrice.replace(",","")*1;
	
	//사용자가 포인트 입력한 후
	inputPoint.addEventListener('blur', function(){
		let val = this.value*1;
		let userPointNum = 0;
		
		//유효성검사
		if(val > memberHavePoint){
			alert("보유금액 이상 사용은 불가능합니다.");
			this.value = memberHavePoint;
			showUsePoint.innerText = memberHavePoint.toLocaleString();
			userPoint.innerText = memberHavePoint.toLocaleString();
			
			//총결제금액
			userPointNum = userPoint.innerText.replace(",", "");
			userTotalPrice.innerText = (userItemPrice+userShipPrice-userPointNum).toLocaleString();
			return;
		}
		
		showUsePoint.innerText = val.toLocaleString();
		userPoint.innerText = val.toLocaleString();
		
		//총결제금액
		userPointNum = userPoint.innerText.replace(",", "");
		userTotalPrice.innerText = (userItemPrice+userShipPrice-userPointNum).toLocaleString();
	});
	
	//전액사용 버튼 클릭한 경우
	btnUseAll.addEventListener('click', function(){
		inputPoint.value = memberHavePoint;
		showUsePoint.innerText = memberHavePoint.toLocaleString();
		userPoint.innerText = memberHavePoint.toLocaleString();
		
		//총결제금액
		userTotalPrice.innerText = (userItemPrice+userShipPrice-memberHavePoint).toLocaleString();
	});
	
}
function calShipItemPrice(){
	//상품정보 금액 변수 
	let itemPriceArr = document.querySelectorAll(".itemPrice"); //상품정보 주문상품금액
	let shipPrice = document.querySelector(".shipPrice").innerText; //상품정보 배송비
	//주문시 결제금액 변수 
	let showPrice = document.querySelector("#showPrice"); //주문시결제금액 주문금액(배송비포함)
	let totalItemPrice = 0; //총 주문상품금액
	let totalShipItemPrice = 0; //총 주문상품금액+배송비
	
	//최종결제금액 변수
	let userItemPrice = document.querySelector("#userItemPrice"); //주문상품
	let userShipPrice = document.querySelector("#userShipPrice"); //배송비
	let userTotalPrice = document.querySelector("#userTotalPrice"); //총 결제금액
	
	//주문시 결제금액 입력
	shipPrice = shipPrice.replace(",", "").replace("원", "")*1; //정수형 변환
	
	itemPriceArr.forEach(function(obj, idx){
		let objPrice = obj.innerText.replace(",", "").replace("원", "")*1;
		totalItemPrice += objPrice;
	})
	
	totalShipItemPrice = shipPrice+totalItemPrice;
	totalShipItemPrice = totalShipItemPrice.toLocaleString();
	
	showPrice.innerText = totalShipItemPrice;
	
	//최종결제금액 입력
	userItemPrice.innerText = totalItemPrice.toLocaleString();
	userShipPrice.innerText = shipPrice.toLocaleString();
	userTotalPrice.innerText = (totalItemPrice+shipPrice).toLocaleString(); //포인트제외
}


