/**
 * 
 */

const $basicBox = document.querySelector("#throttle .scroll-box");
  const $count = document.querySelector("#throttle .count")
  let timer;
  const throttle = (callback, delay) => {
    if(!timer) {
      timer = setTimeout(()=>{
        timer = null;
        callback();
      }, delay);
    }
  };
    
  $basicBox.addEventListener("scroll", event => {
    const {currentTarget} = event;
    throttle(()=>{
      $count.textContent = parseInt($count.textContent)+1;
    }, 1000);
  });