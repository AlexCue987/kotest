"use strict";(self.webpackChunkkotestdocs=self.webpackChunkkotestdocs||[]).push([[92317],{3905:(t,e,a)=>{a.d(e,{Zo:()=>c,kt:()=>u});var n=a(67294);function r(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function l(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,n)}return a}function o(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?l(Object(a),!0).forEach((function(e){r(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):l(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}function i(t,e){if(null==t)return{};var a,n,r=function(t,e){if(null==t)return{};var a,n,r={},l=Object.keys(t);for(n=0;n<l.length;n++)a=l[n],e.indexOf(a)>=0||(r[a]=t[a]);return r}(t,e);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(t);for(n=0;n<l.length;n++)a=l[n],e.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(t,a)&&(r[a]=t[a])}return r}var s=n.createContext({}),m=function(t){var e=n.useContext(s),a=e;return t&&(a="function"==typeof t?t(e):o(o({},e),t)),a},c=function(t){var e=m(t.components);return n.createElement(s.Provider,{value:e},t.children)},p={inlineCode:"code",wrapper:function(t){var e=t.children;return n.createElement(n.Fragment,{},e)}},d=n.forwardRef((function(t,e){var a=t.components,r=t.mdxType,l=t.originalType,s=t.parentName,c=i(t,["components","mdxType","originalType","parentName"]),d=m(a),u=r,h=d["".concat(s,".").concat(u)]||d[u]||p[u]||l;return a?n.createElement(h,o(o({ref:e},c),{},{components:a})):n.createElement(h,o({ref:e},c))}));function u(t,e){var a=arguments,r=e&&e.mdxType;if("string"==typeof t||r){var l=a.length,o=new Array(l);o[0]=d;var i={};for(var s in e)hasOwnProperty.call(e,s)&&(i[s]=e[s]);i.originalType=t,i.mdxType="string"==typeof t?t:r,o[1]=i;for(var m=2;m<l;m++)o[m]=a[m];return n.createElement.apply(null,o)}return n.createElement.apply(null,a)}d.displayName="MDXCreateElement"},78626:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>s,contentTitle:()=>o,default:()=>p,frontMatter:()=>l,metadata:()=>i,toc:()=>m});var n=a(87462),r=(a(67294),a(3905));const l={title:"JSON",slug:"json-overview.html",sidebar_label:"Overview"},o=void 0,i={unversionedId:"assertions/json/overview",id:"version-5.6/assertions/json/overview",title:"JSON",description:"Basic matchers",source:"@site/versioned_docs/version-5.6/assertions/json/overview.md",sourceDirName:"assertions/json",slug:"/assertions/json/json-overview.html",permalink:"/docs/5.6/assertions/json/json-overview.html",draft:!1,editUrl:"https://github.com/kotest/kotest/blob/master/documentation/versioned_docs/version-5.6/assertions/json/overview.md",tags:[],version:"5.6",frontMatter:{title:"JSON",slug:"json-overview.html",sidebar_label:"Overview"},sidebar:"assertions",previous:{title:"Collections",permalink:"/docs/5.6/assertions/collection-matchers.html"},next:{title:"Overview",permalink:"/docs/5.6/assertions/json/json-overview.html"}},s={},m=[{value:"Basic matchers",id:"basic-matchers",level:2},{value:"Content-based matching",id:"content-based-matching",level:2},{value:"Schema validation",id:"schema-validation",level:2}],c={toc:m};function p(t){let{components:e,...a}=t;return(0,r.kt)("wrapper",(0,n.Z)({},c,a,{components:e,mdxType:"MDXLayout"}),(0,r.kt)("h2",{id:"basic-matchers"},"Basic matchers"),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"Matcher"),(0,r.kt)("th",{parentName:"tr",align:null},"Description"),(0,r.kt)("th",{parentName:"tr",align:"left"},"Targets"))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"shouldBeValidJson")),(0,r.kt)("td",{parentName:"tr",align:null},"verifies that a given string parses to valid json"),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"shouldBeJsonObject")),(0,r.kt)("td",{parentName:"tr",align:null},"asserts that a string is a valid JSON ",(0,r.kt)("strong",{parentName:"td"},(0,r.kt)("em",{parentName:"strong"},"object"))),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"shouldBeJsonArray")),(0,r.kt)("td",{parentName:"tr",align:null},"asserts that a string is a valid JSON ",(0,r.kt)("strong",{parentName:"td"},(0,r.kt)("em",{parentName:"strong"},"array"))),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")))),(0,r.kt)("h2",{id:"content-based-matching"},"Content-based matching"),(0,r.kt)("p",null,"For more details, see ",(0,r.kt)("a",{parentName:"p",href:"content-json-matchers.html"},"here")," or follow matcher-specific links below"),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"Matcher"),(0,r.kt)("th",{parentName:"tr",align:null},"Description"),(0,r.kt)("th",{parentName:"tr",align:"left"},"Targets"))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"content-json-matchers.html#shouldequaljson"},"shouldEqualJson")),(0,r.kt)("td",{parentName:"tr",align:null},"Verifies that a String matches a given JSON structure."),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"content-json-matchers.html#shouldequalspecifiedjson"},"shouldEqualSpecifiedJson")),(0,r.kt)("td",{parentName:"tr",align:null},"Verifies that a String matches a given JSON structure, but allows additional unspecified properties."),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"content-json-matchers.html#shouldcontainjsonkey"},"shouldContainJsonKey")),(0,r.kt)("td",{parentName:"tr",align:null},"Verifies that a String is JSON, and contains a given JSON path"),(0,r.kt)("td",{parentName:"tr",align:"left"},"JVM")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"content-json-matchers.html#shouldcontainjsonkey"},"shouldContainJsonKeyValue")),(0,r.kt)("td",{parentName:"tr",align:null},"Verifies that a String is JSON, and contains a given JSON path with the specified value"),(0,r.kt)("td",{parentName:"tr",align:"left"},"JVM")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"content-json-matchers.html#shouldcontainjsonkey"},"shouldMatchJsonResource")),(0,r.kt)("td",{parentName:"tr",align:null},"Verifies that a String is matches the JSON content of a given test resource"),(0,r.kt)("td",{parentName:"tr",align:"left"},"JVM")))),(0,r.kt)("h2",{id:"schema-validation"},"Schema validation"),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"Matcher"),(0,r.kt)("th",{parentName:"tr",align:null},"Description"),(0,r.kt)("th",{parentName:"tr",align:"left"},"Targets"))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("a",{parentName:"td",href:"json-schema-matchers.html"},"shouldMatchSchema")),(0,r.kt)("td",{parentName:"tr",align:null},"Validates that a ",(0,r.kt)("inlineCode",{parentName:"td"},"String")," or ",(0,r.kt)("inlineCode",{parentName:"td"},"kotlinx.serialization.JsonElement")," matches a ",(0,r.kt)("inlineCode",{parentName:"td"},"JsonSchema"),". See description below for details on constructing schemas."),(0,r.kt)("td",{parentName:"tr",align:"left"},"Multiplatform")))))}p.isMDXComponent=!0}}]);