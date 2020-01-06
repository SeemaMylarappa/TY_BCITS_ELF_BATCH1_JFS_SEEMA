function add(a,b){
    var c=a+b;
    return c;
}
var sum=add(10,20);
console.log('Sum is:'+sum)

console.log('=======================================================')

var n1=10;
var str='10';
if(n1===str){
    console.log("Equals")
}else{
    console.log("not equals")
}
console.log('======================================================== ')

var num=[10,20,30];
console.log(typeof(num));
console.log(typeof(null));
console.log(typeof(undefined));
console.log(typeof 'hello');
console.log(typeof true);
console.log(typeof 10)

console.log('==========================')
var isarray=Array.isArray(num);
if(isarray==true){
    console.log('num is an array')
}else{
    console.log('num is not an array')
}
console.log('==========================')
var addM=(a,b)=>a+b;
var s=addM(10,20);
console.log('Sum',s);
 
console.log('==========================')                                            
var sqr=a=>a*a;
var n=sqr(10)
console.log(`Square is ${n}`)
console.log(`Square of 10 is ${10*10}`)


