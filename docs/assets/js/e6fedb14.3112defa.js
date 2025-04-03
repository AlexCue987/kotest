"use strict";(self.webpackChunkkotestdocs=self.webpackChunkkotestdocs||[]).push([[39152],{3905:(t,e,a)=>{a.d(e,{Zo:()=>m,kt:()=>u});var n=a(67294);function r(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function l(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,n)}return a}function i(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?l(Object(a),!0).forEach((function(e){r(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):l(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}function o(t,e){if(null==t)return{};var a,n,r=function(t,e){if(null==t)return{};var a,n,r={},l=Object.keys(t);for(n=0;n<l.length;n++)a=l[n],e.indexOf(a)>=0||(r[a]=t[a]);return r}(t,e);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(t);for(n=0;n<l.length;n++)a=l[n],e.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(t,a)&&(r[a]=t[a])}return r}var d=n.createContext({}),s=function(t){var e=n.useContext(d),a=e;return t&&(a="function"==typeof t?t(e):i(i({},e),t)),a},m=function(t){var e=s(t.components);return n.createElement(d.Provider,{value:e},t.children)},h={inlineCode:"code",wrapper:function(t){var e=t.children;return n.createElement(n.Fragment,{},e)}},p=n.forwardRef((function(t,e){var a=t.components,r=t.mdxType,l=t.originalType,d=t.parentName,m=o(t,["components","mdxType","originalType","parentName"]),p=s(a),u=r,k=p["".concat(d,".").concat(u)]||p[u]||h[u]||l;return a?n.createElement(k,i(i({ref:e},m),{},{components:a})):n.createElement(k,i({ref:e},m))}));function u(t,e){var a=arguments,r=e&&e.mdxType;if("string"==typeof t||r){var l=a.length,i=new Array(l);i[0]=p;var o={};for(var d in e)hasOwnProperty.call(e,d)&&(o[d]=e[d]);o.originalType=t,o.mdxType="string"==typeof t?t:r,i[1]=o;for(var s=2;s<l;s++)i[s]=a[s];return n.createElement.apply(null,i)}return n.createElement.apply(null,a)}p.displayName="MDXCreateElement"},69271:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>d,contentTitle:()=>i,default:()=>h,frontMatter:()=>l,metadata:()=>o,toc:()=>s});var n=a(87462),r=(a(67294),a(3905));const l={id:"kotlinx_datetime",title:"Kotlinx Datetime Matchers",slug:"kotlinx-datetime-matchers.html",sidebar_label:"Kotlinx Datetime"},i=void 0,o={unversionedId:"assertions/kotlinx_datetime",id:"version-5.7/assertions/kotlinx_datetime",title:"Kotlinx Datetime Matchers",description:"Matchers for the Kotlinx Datetime library are provided by the kotest-assertions-kotlinx-time module.",source:"@site/versioned_docs/version-5.7/assertions/kotlinx-datetime.md",sourceDirName:"assertions",slug:"/assertions/kotlinx-datetime-matchers.html",permalink:"/docs/5.7/assertions/kotlinx-datetime-matchers.html",draft:!1,editUrl:"https://github.com/kotest/kotest/blob/master/documentation/versioned_docs/version-5.7/assertions/kotlinx-datetime.md",tags:[],version:"5.7",frontMatter:{id:"kotlinx_datetime",title:"Kotlinx Datetime Matchers",slug:"kotlinx-datetime-matchers.html",sidebar_label:"Kotlinx Datetime"},sidebar:"assertions",previous:{title:"Ktor",permalink:"/docs/5.7/assertions/ktor-matchers.html"},next:{title:"Arrow",permalink:"/docs/5.7/assertions/arrow.html"}},d={},s=[],m={toc:s};function h(t){let{components:e,...a}=t;return(0,r.kt)("wrapper",(0,n.Z)({},m,a,{components:e,mdxType:"MDXLayout"}),(0,r.kt)("p",null,"Matchers for the ",(0,r.kt)("a",{parentName:"p",href:"https://github.com/Kotlin/kotlinx-datetime"},"Kotlinx Datetime")," library are provided by the ",(0,r.kt)("inlineCode",{parentName:"p"},"kotest-assertions-kotlinx-time")," module."),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"LocalDate"),(0,r.kt)("th",{parentName:"tr",align:null}))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveSameYearAs(otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date has the same year as the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveSameMonthAs(otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date has the same month as the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveSameDayAs(otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date has the same day of the month as the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldBeBefore(otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date is before the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldBeAfter(otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date is after the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldBeWithin(period, otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date is within the period of the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldBeWithin(duration, otherDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date is within the duration of the given date.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldBeBetween(firstDate, secondDate)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date is between firstdate and seconddate.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveYear(year)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct year.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveMonth(month)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct month.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveDayOfYear(day)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct day of year.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveDayOfMonth(day)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct day of month.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveDayOfWeek(day)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct day of week.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveHour(hour)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct hour.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveMinute(Minute)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct minute.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveSecond(second)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct second.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"date.shouldHaveNano(nano)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the date have correct nano second.")))),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"LocalDateTime"),(0,r.kt)("th",{parentName:"tr",align:null}))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldHaveSameHoursAs(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time has the same hours as the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldHaveSameMinutesAs(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time has the same minutes as the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldHaveSameSecondsAs(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time has the same seconds as the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldHaveSameNanosAs(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time has the same nanos as the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldBeBefore(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time is before the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldBeAfter(otherTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time is after the given time.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"time.shouldBeBetween(firstTime, secondTime)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the time is between firstTime and secondTime.")))),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:null},"Instant"),(0,r.kt)("th",{parentName:"tr",align:null}))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"instant.shouldBeAfter(anotherInstant)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the instant is after anotherInstant")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"instant.shouldBeBefore(anotherInstant)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the instant is before anotherInstant")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:null},(0,r.kt)("inlineCode",{parentName:"td"},"instant.shouldBeBetween(fromInstant, toInstant)")),(0,r.kt)("td",{parentName:"tr",align:null},"Asserts that the instant is between fromInstant and toInstant")))))}h.isMDXComponent=!0}}]);