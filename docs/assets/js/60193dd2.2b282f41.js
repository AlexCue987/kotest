"use strict";(self.webpackChunkkotestdocs=self.webpackChunkkotestdocs||[]).push([[43884],{3905:(e,t,r)=>{r.d(t,{Zo:()=>p,kt:()=>f});var n=r(67294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function a(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?a(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):a(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function s(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},a=Object.keys(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var l=n.createContext({}),c=function(e){var t=n.useContext(l),r=t;return e&&(r="function"==typeof e?e(t):i(i({},t),e)),r},p=function(e){var t=c(e.components);return n.createElement(l.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},m=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,a=e.originalType,l=e.parentName,p=s(e,["components","mdxType","originalType","parentName"]),m=c(r),f=o,d=m["".concat(l,".").concat(f)]||m[f]||u[f]||a;return r?n.createElement(d,i(i({ref:t},p),{},{components:r})):n.createElement(d,i({ref:t},p))}));function f(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=r.length,i=new Array(a);i[0]=m;var s={};for(var l in t)hasOwnProperty.call(t,l)&&(s[l]=t[l]);s.originalType=e,s.mdxType="string"==typeof e?e:o,i[1]=s;for(var c=2;c<a;c++)i[c]=r[c];return n.createElement.apply(null,i)}return n.createElement.apply(null,r)}m.displayName="MDXCreateElement"},65636:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>l,contentTitle:()=>i,default:()=>u,frontMatter:()=>a,metadata:()=>s,toc:()=>c});var n=r(87462),o=(r(67294),r(3905));const a={id:"fail_on_empty",title:"Fail On Empty Test Suite",slug:"fail-on-empty-test-suite.html",sidebar_label:"Fail On Empty Test Suite"},i=void 0,s={unversionedId:"framework/fail_on_empty",id:"framework/fail_on_empty",title:"Fail On Empty Test Suite",description:"To ensure that a project always executes at least one test,",source:"@site/docs/framework/fail_on_empty.md",sourceDirName:"framework",slug:"/framework/fail-on-empty-test-suite.html",permalink:"/docs/next/framework/fail-on-empty-test-suite.html",draft:!1,editUrl:"https://github.com/kotest/kotest/blob/master/documentation/docs/framework/fail_on_empty.md",tags:[],version:"current",frontMatter:{id:"fail_on_empty",title:"Fail On Empty Test Suite",slug:"fail-on-empty-test-suite.html",sidebar_label:"Fail On Empty Test Suite"},sidebar:"framework",previous:{title:"Fail Fast",permalink:"/docs/next/framework/fail-fast.html"},next:{title:"Config Dump",permalink:"/docs/next/framework/config-dump.html"}},l={},c=[],p={toc:c};function u(e){let{components:t,...r}=e;return(0,o.kt)("wrapper",(0,n.Z)({},p,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"To ensure that a project always executes at least one test,\nyou can enable ",(0,o.kt)("inlineCode",{parentName:"p"},"failOnEmptyTestSuite")," in ",(0,o.kt)("a",{parentName:"p",href:"/docs/next/framework/project-config.html"},"project config"),"."),(0,o.kt)("p",null,"If this is set to true and a module has no tests executed then the build will fail."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},"class ProjectConfig : AbstractProjectConfig() {\n  override val failOnEmptyTestSuite = true\n}\n")),(0,o.kt)("admonition",{type:"tip"},(0,o.kt)("p",{parentName:"admonition"},"A module is considered empty if no tests are ",(0,o.kt)("em",{parentName:"p"},"executed")," regardless of whether tests are defined. This is useful to\ncatch scenarios were tests are being filtered out erroneously, such as by environment specific settings.")))}u.isMDXComponent=!0}}]);