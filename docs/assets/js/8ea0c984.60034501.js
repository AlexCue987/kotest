"use strict";(self.webpackChunkkotestdocs=self.webpackChunkkotestdocs||[]).push([[47984],{3905:(e,t,r)=>{r.d(t,{Zo:()=>p,kt:()=>f});var n=r(67294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function s(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function a(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?s(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):s(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function i(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},s=Object.keys(e);for(n=0;n<s.length;n++)r=s[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);for(n=0;n<s.length;n++)r=s[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var l=n.createContext({}),c=function(e){var t=n.useContext(l),r=t;return e&&(r="function"==typeof e?e(t):a(a({},t),e)),r},p=function(e){var t=c(e.components);return n.createElement(l.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,s=e.originalType,l=e.parentName,p=i(e,["components","mdxType","originalType","parentName"]),d=c(r),f=o,m=d["".concat(l,".").concat(f)]||d[f]||u[f]||s;return r?n.createElement(m,a(a({ref:t},p),{},{components:r})):n.createElement(m,a({ref:t},p))}));function f(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var s=r.length,a=new Array(s);a[0]=d;var i={};for(var l in t)hasOwnProperty.call(t,l)&&(i[l]=t[l]);i.originalType=e,i.mdxType="string"==typeof e?e:o,a[1]=i;for(var c=2;c<s;c++)a[c]=r[c];return n.createElement.apply(null,a)}return n.createElement.apply(null,r)}d.displayName="MDXCreateElement"},4462:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>l,contentTitle:()=>a,default:()=>u,frontMatter:()=>s,metadata:()=>i,toc:()=>c});var n=r(87462),o=(r(67294),r(3905));const s={id:"dsl",title:"Kotest DSL",slug:"dsl.html",sidebar_label:"Kotest DSL"},a=void 0,i={unversionedId:"framework/dsl",id:"version-5.3/framework/dsl",title:"Kotest DSL",description:"This page discusses in detail the Kotest DSL that is used to build tests. You do not need to read this page",source:"@site/versioned_docs/version-5.3/framework/dsl.md",sourceDirName:"framework",slug:"/framework/dsl.html",permalink:"/docs/5.3/framework/dsl.html",draft:!1,editUrl:"https://github.com/kotest/kotest/blob/master/documentation/versioned_docs/version-5.3/framework/dsl.md",tags:[],version:"5.3",frontMatter:{id:"dsl",title:"Kotest DSL",slug:"dsl.html",sidebar_label:"Kotest DSL"}},l={},c=[{value:"Tests",id:"tests",level:3},{value:"Spec",id:"spec",level:3}],p={toc:c};function u(e){let{components:t,...r}=e;return(0,o.kt)("wrapper",(0,n.Z)({},p,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"This page discusses in detail the Kotest DSL that is used to build tests. You do not need to read this page\nto effectively use Kotest, but it may be of interest to users who are implementing extensions or\nraising PRs on Kotest itself or anyone who is just curious how things work under the hood."),(0,o.kt)("h3",{id:"tests"},"Tests"),(0,o.kt)("p",null,"In Kotest a test is essentially just a function ",(0,o.kt)("inlineCode",{parentName:"p"},"TestContext -> Unit"),". This function will contain assertions\n(",(0,o.kt)("em",{parentName:"p"},"matchers")," in Kotest nomenclature) which will throw an exception if the assertion fails. These exceptions are\nthen intercepted by the framework and used to mark a test as ",(0,o.kt)("em",{parentName:"p"},"failed")," or ",(0,o.kt)("em",{parentName:"p"},"errored")," (depending on the exception class)."),(0,o.kt)("h3",{id:"spec"},"Spec"),(0,o.kt)("p",null,"The basic unit of currency in Kotest is the spec. A spec is the top most container of tests and is essentially\njust a class that extends one of the spec styles (FunSpec, DescribeSpec and so on)."),(0,o.kt)("p",null,"Each spec contains tests which are referred to as ",(0,o.kt)("em",{parentName:"p"},"root tests")," (rooted in reference to the spec). These root\ntests are registered"))}u.isMDXComponent=!0}}]);