"use strict";(self.webpackChunkkotestdocs=self.webpackChunkkotestdocs||[]).push([[51933],{3905:(e,t,n)=>{n.d(t,{Zo:()=>u,kt:()=>d});var r=n(67294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function s(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function o(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},i=Object.keys(e);for(r=0;r<i.length;r++)n=i[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(r=0;r<i.length;r++)n=i[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var l=r.createContext({}),c=function(e){var t=r.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):s(s({},t),e)),n},u=function(e){var t=c(e.components);return r.createElement(l.Provider,{value:t},e.children)},p={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},m=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,i=e.originalType,l=e.parentName,u=o(e,["components","mdxType","originalType","parentName"]),m=c(n),d=a,f=m["".concat(l,".").concat(d)]||m[d]||p[d]||i;return n?r.createElement(f,s(s({ref:t},u),{},{components:n})):r.createElement(f,s({ref:t},u))}));function d(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var i=n.length,s=new Array(i);s[0]=m;var o={};for(var l in t)hasOwnProperty.call(t,l)&&(o[l]=t[l]);o.originalType=e,o.mdxType="string"==typeof e?e:a,s[1]=o;for(var c=2;c<i;c++)s[c]=n[c];return r.createElement.apply(null,s)}return r.createElement.apply(null,n)}m.displayName="MDXCreateElement"},51590:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>l,contentTitle:()=>s,default:()=>p,frontMatter:()=>i,metadata:()=>o,toc:()=>c});var r=n(87462),a=(n(67294),n(3905));const i={id:"similarity",title:"Partial Matches",slug:"similarity.html"},s=void 0,o={unversionedId:"assertions/similarity",id:"assertions/similarity",title:"Partial Matches",description:"If kotest fails to match a String or an instance of a data class, it may try to find something similar.",source:"@site/docs/assertions/similarity.md",sourceDirName:"assertions",slug:"/assertions/similarity.html",permalink:"/docs/next/assertions/similarity.html",draft:!1,editUrl:"https://github.com/kotest/kotest/blob/master/documentation/docs/assertions/similarity.md",tags:[],version:"current",frontMatter:{id:"similarity",title:"Partial Matches",slug:"similarity.html"},sidebar:"assertions",previous:{title:"Exceptions",permalink:"/docs/next/assertions/exceptions.html"},next:{title:"Clues",permalink:"/docs/next/assertions/clues.html"}},l={},c=[],u={toc:c};function p(e){let{components:t,...n}=e;return(0,a.kt)("wrapper",(0,r.Z)({},u,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("p",null,"If kotest fails to match a ",(0,a.kt)("inlineCode",{parentName:"p"},"String")," or an instance of a data class, it may try to find something similar.\nFor instance, in the following example two fields out of three match, so kotest considers ",(0,a.kt)("inlineCode",{parentName:"p"},"sweetGreenApple")," to be 66.6% similar to sweetRedApple:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},'listOf(sweetGreenApple, sweetGreenPear) shouldContain (sweetRedApple)\n\n(snip)\n\nPossibleMatches:\n expected: Fruit(name=apple, color=red, taste=sweet),\n  but was: Fruit(name=apple, color=green, taste=sweet),\n  The following fields did not match:\n    "color" expected: <"red">, but was: <"green">\n')),(0,a.kt)("p",null,"By default, kotest will only consider pairs of objects that have more than 50% matching fields. If needed, we can change ",(0,a.kt)("inlineCode",{parentName:"p"},"similarityThresholdInPercent")," in configuration."),(0,a.kt)("p",null,"Likewise, if kotest does not detect an exact match, it may try to find a similar ",(0,a.kt)("inlineCode",{parentName:"p"},"String"),". In the output, the matching part of String is indicated with plus signs:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},'listOf("sweet green apple", "sweet red plum") shouldContain ("sweet green pear")\n\n(snip)\n\nPossibleMatches:\nMatch[0]: part of slice with indexes [0..11] matched actual[0..11]\nLine[0] ="sweet green apple"\nMatch[0]= ++++++++++++-----\n')),(0,a.kt)("p",null,"By default, searching for similar strings is only enabled when both expected and actuals strings' lengthes are between 8 and 1024. "),(0,a.kt)("br",null),"If we need to consider shorter or longer expected values, we can change configuration values named `minSubstringSubmatchingSize` and `maxSubtringSubmatchingSize`.",(0,a.kt)("br",null),"Likewise, should we need to consider shorter or longer actual values, we can change configuration values named `minValueSubmatchingSize` and `maxValueSubmatchingSize`.",(0,a.kt)("br",null),(0,a.kt)("br",null),"By default, possible matches that are less than 66% similar are dismissed, and that default can be changed via `similarityThresholdInPercentForStrings` value in configuration.",(0,a.kt)("br",null),(0,a.kt)("br",null),"To disable searching for similar strings altogether, set `enabledSubmatchesInStrings` to `false` in configuration.")}p.isMDXComponent=!0}}]);