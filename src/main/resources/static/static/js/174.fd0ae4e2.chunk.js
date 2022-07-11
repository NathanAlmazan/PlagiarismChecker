"use strict";(self.webpackChunkplagiarism=self.webpackChunkplagiarism||[]).push([[174],{9027:function(e,n,t){var r=t(5318);n.Z=void 0;var o=r(t(5649)),i=t(184),a=(0,o.default)([(0,i.jsx)("path",{d:"M19 5v14H5V5h14m0-2H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"},"0"),(0,i.jsx)("path",{d:"M14 17H7v-2h7v2zm3-4H7v-2h10v2zm0-4H7V7h10v2z"},"1")],"ArticleOutlined");n.Z=a},600:function(e,n,t){var r=t(5318);n.Z=void 0;var o=r(t(5649)),i=t(184),a=(0,o.default)((0,i.jsx)("path",{d:"M19.35 10.04C18.67 6.59 15.64 4 12 4 9.11 4 6.6 5.64 5.35 8.04 2.34 8.36 0 10.91 0 14c0 3.31 2.69 6 6 6h13c2.76 0 5-2.24 5-5 0-2.64-2.05-4.78-4.65-4.96zM19 18H6c-2.21 0-4-1.79-4-4 0-2.05 1.53-3.76 3.56-3.97l1.07-.11.5-.95C8.08 7.14 9.94 6 12 6c2.62 0 4.88 1.86 5.39 4.43l.3 1.5 1.53.11c1.56.1 2.78 1.41 2.78 2.96 0 1.65-1.35 3-3 3zM8 13h2.55v3h2.9v-3H16l-4-4z"}),"CloudUploadOutlined");n.Z=a},9998:function(e,n){n.Z=function(e,n){if(e&&n){var t=Array.isArray(n)?n:n.split(","),r=e.name||"",o=(e.type||"").toLowerCase(),i=o.replace(/\/.*$/,"");return t.some((function(e){var n=e.trim().toLowerCase();return"."===n.charAt(0)?r.toLowerCase().endsWith(n):n.endsWith("/*")?i===n.replace(/\/.*$/,""):o===n}))}return!0}},8267:function(e,n,t){t.d(n,{ZP:function(){return de}});var r=t(2791),o=t(2007),i=t.n(o),a=t(9388),c=new Map([["aac","audio/aac"],["abw","application/x-abiword"],["arc","application/x-freearc"],["avif","image/avif"],["avi","video/x-msvideo"],["azw","application/vnd.amazon.ebook"],["bin","application/octet-stream"],["bmp","image/bmp"],["bz","application/x-bzip"],["bz2","application/x-bzip2"],["cda","application/x-cdf"],["csh","application/x-csh"],["css","text/css"],["csv","text/csv"],["doc","application/msword"],["docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"],["eot","application/vnd.ms-fontobject"],["epub","application/epub+zip"],["gz","application/gzip"],["gif","image/gif"],["heic","image/heic"],["heif","image/heif"],["htm","text/html"],["html","text/html"],["ico","image/vnd.microsoft.icon"],["ics","text/calendar"],["jar","application/java-archive"],["jpeg","image/jpeg"],["jpg","image/jpeg"],["js","text/javascript"],["json","application/json"],["jsonld","application/ld+json"],["mid","audio/midi"],["midi","audio/midi"],["mjs","text/javascript"],["mp3","audio/mpeg"],["mp4","video/mp4"],["mpeg","video/mpeg"],["mpkg","application/vnd.apple.installer+xml"],["odp","application/vnd.oasis.opendocument.presentation"],["ods","application/vnd.oasis.opendocument.spreadsheet"],["odt","application/vnd.oasis.opendocument.text"],["oga","audio/ogg"],["ogv","video/ogg"],["ogx","application/ogg"],["opus","audio/opus"],["otf","font/otf"],["png","image/png"],["pdf","application/pdf"],["php","application/x-httpd-php"],["ppt","application/vnd.ms-powerpoint"],["pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation"],["rar","application/vnd.rar"],["rtf","application/rtf"],["sh","application/x-sh"],["svg","image/svg+xml"],["swf","application/x-shockwave-flash"],["tar","application/x-tar"],["tif","image/tiff"],["tiff","image/tiff"],["ts","video/mp2t"],["ttf","font/ttf"],["txt","text/plain"],["vsd","application/vnd.visio"],["wav","audio/wav"],["weba","audio/webm"],["webm","video/webm"],["webp","image/webp"],["woff","font/woff"],["woff2","font/woff2"],["xhtml","application/xhtml+xml"],["xls","application/vnd.ms-excel"],["xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"],["xml","application/xml"],["xul","application/vnd.mozilla.xul+xml"],["zip","application/zip"],["7z","application/x-7z-compressed"],["mkv","video/x-matroska"],["mov","video/quicktime"],["msg","application/vnd.ms-outlook"]]);function u(e,n){var t=function(e){var n=e.name;if(n&&-1!==n.lastIndexOf(".")&&!e.type){var t=n.split(".").pop().toLowerCase(),r=c.get(t);r&&Object.defineProperty(e,"type",{value:r,writable:!1,configurable:!1,enumerable:!0})}return e}(e);if("string"!==typeof t.path){var r=e.webkitRelativePath;Object.defineProperty(t,"path",{value:"string"===typeof n?n:"string"===typeof r&&r.length>0?r:e.name,writable:!1,configurable:!1,enumerable:!0})}return t}var l=[".DS_Store","Thumbs.db"];function s(e){return"object"===typeof e&&null!==e}function f(e){return m(e.target.files).map((function(e){return u(e)}))}function p(e){return(0,a.mG)(this,void 0,void 0,(function(){return(0,a.Jh)(this,(function(n){switch(n.label){case 0:return[4,Promise.all(e.map((function(e){return e.getFile()})))];case 1:return[2,n.sent().map((function(e){return u(e)}))]}}))}))}function d(e,n){return(0,a.mG)(this,void 0,void 0,(function(){var t;return(0,a.Jh)(this,(function(r){switch(r.label){case 0:return e.items?(t=m(e.items).filter((function(e){return"file"===e.kind})),"drop"!==n?[2,t]:[4,Promise.all(t.map(g))]):[3,2];case 1:return[2,v(y(r.sent()))];case 2:return[2,v(m(e.files).map((function(e){return u(e)})))]}}))}))}function v(e){return e.filter((function(e){return-1===l.indexOf(e.name)}))}function m(e){if(null===e)return[];for(var n=[],t=0;t<e.length;t++){var r=e[t];n.push(r)}return n}function g(e){if("function"!==typeof e.webkitGetAsEntry)return b(e);var n=e.webkitGetAsEntry();return n&&n.isDirectory?w(n):b(e)}function y(e){return e.reduce((function(e,n){return(0,a.ev)((0,a.ev)([],(0,a.CR)(e),!1),(0,a.CR)(Array.isArray(n)?y(n):[n]),!1)}),[])}function b(e){var n=e.getAsFile();if(!n)return Promise.reject("".concat(e," is not a File"));var t=u(n);return Promise.resolve(t)}function h(e){return(0,a.mG)(this,void 0,void 0,(function(){return(0,a.Jh)(this,(function(n){return[2,e.isDirectory?w(e):D(e)]}))}))}function w(e){var n=e.createReader();return new Promise((function(e,t){var r=[];!function o(){var i=this;n.readEntries((function(n){return(0,a.mG)(i,void 0,void 0,(function(){var i,c,u;return(0,a.Jh)(this,(function(a){switch(a.label){case 0:if(n.length)return[3,5];a.label=1;case 1:return a.trys.push([1,3,,4]),[4,Promise.all(r)];case 2:return i=a.sent(),e(i),[3,4];case 3:return c=a.sent(),t(c),[3,4];case 4:return[3,6];case 5:u=Promise.all(n.map(h)),r.push(u),o(),a.label=6;case 6:return[2]}}))}))}),(function(e){t(e)}))}()}))}function D(e){return(0,a.mG)(this,void 0,void 0,(function(){return(0,a.Jh)(this,(function(n){return[2,new Promise((function(n,t){e.file((function(t){var r=u(t,e.fullPath);n(r)}),(function(e){t(e)}))}))]}))}))}var x=t(9998);function A(e){return function(e){if(Array.isArray(e))return F(e)}(e)||function(e){if("undefined"!==typeof Symbol&&null!=e[Symbol.iterator]||null!=e["@@iterator"])return Array.from(e)}(e)||O(e)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function j(e,n){return function(e){if(Array.isArray(e))return e}(e)||function(e,n){var t=null==e?null:"undefined"!==typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(null==t)return;var r,o,i=[],a=!0,c=!1;try{for(t=t.call(e);!(a=(r=t.next()).done)&&(i.push(r.value),!n||i.length!==n);a=!0);}catch(u){c=!0,o=u}finally{try{a||null==t.return||t.return()}finally{if(c)throw o}}return i}(e,n)||O(e,n)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function O(e,n){if(e){if("string"===typeof e)return F(e,n);var t=Object.prototype.toString.call(e).slice(8,-1);return"Object"===t&&e.constructor&&(t=e.constructor.name),"Map"===t||"Set"===t?Array.from(e):"Arguments"===t||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(t)?F(e,n):void 0}}function F(e,n){(null==n||n>e.length)&&(n=e.length);for(var t=0,r=new Array(n);t<n;t++)r[t]=e[t];return r}var E="file-invalid-type",k="file-too-large",C="file-too-small",S="too-many-files",z=function(e){e=Array.isArray(e)&&1===e.length?e[0]:e;var n=Array.isArray(e)?"one of ".concat(e.join(", ")):e;return{code:E,message:"File type must be ".concat(n)}},P=function(e){return{code:k,message:"File is larger than ".concat(e," ").concat(1===e?"byte":"bytes")}},R=function(e){return{code:C,message:"File is smaller than ".concat(e," ").concat(1===e?"byte":"bytes")}},I={code:S,message:"Too many files"};function M(e,n){var t="application/x-moz-file"===e.type||(0,x.Z)(e,n);return[t,t?null:z(n)]}function T(e,n,t){if(L(e.size))if(L(n)&&L(t)){if(e.size>t)return[!1,P(t)];if(e.size<n)return[!1,R(n)]}else{if(L(n)&&e.size<n)return[!1,R(n)];if(L(t)&&e.size>t)return[!1,P(t)]}return[!0,null]}function L(e){return void 0!==e&&null!==e}function B(e){var n=e.files,t=e.accept,r=e.minSize,o=e.maxSize,i=e.multiple,a=e.maxFiles,c=e.validator;return!(!i&&n.length>1||i&&a>=1&&n.length>a)&&n.every((function(e){var n=j(M(e,t),1)[0],i=j(T(e,r,o),1)[0],a=c?c(e):null;return n&&i&&!a}))}function H(e){return"function"===typeof e.isPropagationStopped?e.isPropagationStopped():"undefined"!==typeof e.cancelBubble&&e.cancelBubble}function K(e){return e.dataTransfer?Array.prototype.some.call(e.dataTransfer.types,(function(e){return"Files"===e||"application/x-moz-file"===e})):!!e.target&&!!e.target.files}function _(e){e.preventDefault()}function G(e){return-1!==e.indexOf("MSIE")||-1!==e.indexOf("Trident/")}function Z(e){return-1!==e.indexOf("Edge/")}function J(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:window.navigator.userAgent;return G(e)||Z(e)}function U(){for(var e=arguments.length,n=new Array(e),t=0;t<e;t++)n[t]=arguments[t];return function(e){for(var t=arguments.length,r=new Array(t>1?t-1:0),o=1;o<t;o++)r[o-1]=arguments[o];return n.some((function(n){return!H(e)&&n&&n.apply(void 0,[e].concat(r)),H(e)}))}}function $(){return"showOpenFilePicker"in window}function W(e){return L(e)?Object.entries(e).filter((function(e){var n=j(e,2),t=n[0],r=n[1],o=!0;return Y(t)||(console.warn('Skipped "'.concat(t,'" because it is not a valid MIME type. Check https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types for a list of valid MIME types.')),o=!1),Array.isArray(r)&&r.every(Q)||(console.warn('Skipped "'.concat(t,'" because an invalid file extension was provided.')),o=!1),o})).map((function(e){var n,t,r,o=j(e,2),i=o[0],a=o[1];return{accept:(n={},t=i,r=a,t in n?Object.defineProperty(n,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):n[t]=r,n)}})):e}function V(e){if(L(e))return Object.entries(e).reduce((function(e,n){var t=j(n,2),r=t[0],o=t[1];return[].concat(A(e),[r],A(o))}),[]).filter((function(e){return Y(e)||Q(e)})).join(",")}function q(e){return e instanceof DOMException&&("AbortError"===e.name||e.code===e.ABORT_ERR)}function N(e){return e instanceof DOMException&&("SecurityError"===e.name||e.code===e.SECURITY_ERR)}function Y(e){return"audio/*"===e||"video/*"===e||"image/*"===e||"text/*"===e||/\w+\/[-+.\w]+/g.test(e)}function Q(e){return/^.*\.[\w]+$/.test(e)}var X=["children"],ee=["open"],ne=["refKey","role","onKeyDown","onFocus","onBlur","onClick","onDragEnter","onDragOver","onDragLeave","onDrop"],te=["refKey","onChange","onClick"];function re(e){return function(e){if(Array.isArray(e))return ae(e)}(e)||function(e){if("undefined"!==typeof Symbol&&null!=e[Symbol.iterator]||null!=e["@@iterator"])return Array.from(e)}(e)||ie(e)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function oe(e,n){return function(e){if(Array.isArray(e))return e}(e)||function(e,n){var t=null==e?null:"undefined"!==typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(null==t)return;var r,o,i=[],a=!0,c=!1;try{for(t=t.call(e);!(a=(r=t.next()).done)&&(i.push(r.value),!n||i.length!==n);a=!0);}catch(u){c=!0,o=u}finally{try{a||null==t.return||t.return()}finally{if(c)throw o}}return i}(e,n)||ie(e,n)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function ie(e,n){if(e){if("string"===typeof e)return ae(e,n);var t=Object.prototype.toString.call(e).slice(8,-1);return"Object"===t&&e.constructor&&(t=e.constructor.name),"Map"===t||"Set"===t?Array.from(e):"Arguments"===t||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(t)?ae(e,n):void 0}}function ae(e,n){(null==n||n>e.length)&&(n=e.length);for(var t=0,r=new Array(n);t<n;t++)r[t]=e[t];return r}function ce(e,n){var t=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);n&&(r=r.filter((function(n){return Object.getOwnPropertyDescriptor(e,n).enumerable}))),t.push.apply(t,r)}return t}function ue(e){for(var n=1;n<arguments.length;n++){var t=null!=arguments[n]?arguments[n]:{};n%2?ce(Object(t),!0).forEach((function(n){le(e,n,t[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(t)):ce(Object(t)).forEach((function(n){Object.defineProperty(e,n,Object.getOwnPropertyDescriptor(t,n))}))}return e}function le(e,n,t){return n in e?Object.defineProperty(e,n,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[n]=t,e}function se(e,n){if(null==e)return{};var t,r,o=function(e,n){if(null==e)return{};var t,r,o={},i=Object.keys(e);for(r=0;r<i.length;r++)t=i[r],n.indexOf(t)>=0||(o[t]=e[t]);return o}(e,n);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(r=0;r<i.length;r++)t=i[r],n.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(e,t)&&(o[t]=e[t])}return o}var fe=(0,r.forwardRef)((function(e,n){var t=e.children,o=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},n=ue(ue({},pe),e),t=n.accept,o=n.disabled,i=n.getFilesFromEvent,a=n.maxSize,c=n.minSize,u=n.multiple,l=n.maxFiles,s=n.onDragEnter,f=n.onDragLeave,p=n.onDragOver,d=n.onDrop,v=n.onDropAccepted,m=n.onDropRejected,g=n.onFileDialogCancel,y=n.onFileDialogOpen,b=n.useFsAccessApi,h=n.autoFocus,w=n.preventDropOnDocument,D=n.noClick,x=n.noKeyboard,A=n.noDrag,j=n.noDragEventsBubbling,O=n.onError,F=n.validator,E=(0,r.useMemo)((function(){return V(t)}),[t]),k=(0,r.useMemo)((function(){return W(t)}),[t]),C=(0,r.useMemo)((function(){return"function"===typeof y?y:ge}),[y]),S=(0,r.useMemo)((function(){return"function"===typeof g?g:ge}),[g]),z=(0,r.useRef)(null),P=(0,r.useRef)(null),R=oe((0,r.useReducer)(me,ve),2),L=R[0],G=R[1],Z=L.isFocused,Y=L.isFileDialogActive,Q=(0,r.useRef)("undefined"!==typeof window&&window.isSecureContext&&b&&$()),X=function(){!Q.current&&Y&&setTimeout((function(){P.current&&(P.current.files.length||(G({type:"closeDialog"}),S()))}),300)};(0,r.useEffect)((function(){return window.addEventListener("focus",X,!1),function(){window.removeEventListener("focus",X,!1)}}),[P,Y,S,Q]);var ee=(0,r.useRef)([]),ie=function(e){z.current&&z.current.contains(e.target)||(e.preventDefault(),ee.current=[])};(0,r.useEffect)((function(){return w&&(document.addEventListener("dragover",_,!1),document.addEventListener("drop",ie,!1)),function(){w&&(document.removeEventListener("dragover",_),document.removeEventListener("drop",ie))}}),[z,w]),(0,r.useEffect)((function(){return!o&&h&&z.current&&z.current.focus(),function(){}}),[z,h,o]);var ae=(0,r.useCallback)((function(e){O?O(e):console.error(e)}),[O]),ce=(0,r.useCallback)((function(e){e.preventDefault(),e.persist(),Ee(e),ee.current=[].concat(re(ee.current),[e.target]),K(e)&&Promise.resolve(i(e)).then((function(n){if(!H(e)||j){var t=n.length,r=t>0&&B({files:n,accept:E,minSize:c,maxSize:a,multiple:u,maxFiles:l,validator:F});G({isDragAccept:r,isDragReject:t>0&&!r,isDragActive:!0,type:"setDraggedFiles"}),s&&s(e)}})).catch((function(e){return ae(e)}))}),[i,s,ae,j,E,c,a,u,l,F]),fe=(0,r.useCallback)((function(e){e.preventDefault(),e.persist(),Ee(e);var n=K(e);if(n&&e.dataTransfer)try{e.dataTransfer.dropEffect="copy"}catch(t){}return n&&p&&p(e),!1}),[p,j]),de=(0,r.useCallback)((function(e){e.preventDefault(),e.persist(),Ee(e);var n=ee.current.filter((function(e){return z.current&&z.current.contains(e)})),t=n.indexOf(e.target);-1!==t&&n.splice(t,1),ee.current=n,n.length>0||(G({type:"setDraggedFiles",isDragActive:!1,isDragAccept:!1,isDragReject:!1}),K(e)&&f&&f(e))}),[z,f,j]),ye=(0,r.useCallback)((function(e,n){var t=[],r=[];e.forEach((function(e){var n=oe(M(e,E),2),o=n[0],i=n[1],u=oe(T(e,c,a),2),l=u[0],s=u[1],f=F?F(e):null;if(o&&l&&!f)t.push(e);else{var p=[i,s];f&&(p=p.concat(f)),r.push({file:e,errors:p.filter((function(e){return e}))})}})),(!u&&t.length>1||u&&l>=1&&t.length>l)&&(t.forEach((function(e){r.push({file:e,errors:[I]})})),t.splice(0)),G({acceptedFiles:t,fileRejections:r,type:"setFiles"}),d&&d(t,r,n),r.length>0&&m&&m(r,n),t.length>0&&v&&v(t,n)}),[G,u,E,c,a,l,d,v,m,F]),be=(0,r.useCallback)((function(e){e.preventDefault(),e.persist(),Ee(e),ee.current=[],K(e)&&Promise.resolve(i(e)).then((function(n){H(e)&&!j||ye(n,e)})).catch((function(e){return ae(e)})),G({type:"reset"})}),[i,ye,ae,j]),he=(0,r.useCallback)((function(){if(Q.current){G({type:"openDialog"}),C();var e={multiple:u,types:k};window.showOpenFilePicker(e).then((function(e){return i(e)})).then((function(e){ye(e,null),G({type:"closeDialog"})})).catch((function(e){q(e)?(S(e),G({type:"closeDialog"})):N(e)?(Q.current=!1,P.current?(P.current.value=null,P.current.click()):ae(new Error("Cannot open the file picker because the https://developer.mozilla.org/en-US/docs/Web/API/File_System_Access_API is not supported and no <input> was provided."))):ae(e)}))}else P.current&&(G({type:"openDialog"}),C(),P.current.value=null,P.current.click())}),[G,C,S,b,ye,ae,k,u]),we=(0,r.useCallback)((function(e){z.current&&z.current.isEqualNode(e.target)&&(" "!==e.key&&"Enter"!==e.key&&32!==e.keyCode&&13!==e.keyCode||(e.preventDefault(),he()))}),[z,he]),De=(0,r.useCallback)((function(){G({type:"focus"})}),[]),xe=(0,r.useCallback)((function(){G({type:"blur"})}),[]),Ae=(0,r.useCallback)((function(){D||(J()?setTimeout(he,0):he())}),[D,he]),je=function(e){return o?null:e},Oe=function(e){return x?null:je(e)},Fe=function(e){return A?null:je(e)},Ee=function(e){j&&e.stopPropagation()},ke=(0,r.useMemo)((function(){return function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},n=e.refKey,t=void 0===n?"ref":n,r=e.role,i=e.onKeyDown,a=e.onFocus,c=e.onBlur,u=e.onClick,l=e.onDragEnter,s=e.onDragOver,f=e.onDragLeave,p=e.onDrop,d=se(e,ne);return ue(ue(le({onKeyDown:Oe(U(i,we)),onFocus:Oe(U(a,De)),onBlur:Oe(U(c,xe)),onClick:je(U(u,Ae)),onDragEnter:Fe(U(l,ce)),onDragOver:Fe(U(s,fe)),onDragLeave:Fe(U(f,de)),onDrop:Fe(U(p,be)),role:"string"===typeof r&&""!==r?r:"presentation"},t,z),o||x?{}:{tabIndex:0}),d)}}),[z,we,De,xe,Ae,ce,fe,de,be,x,A,o]),Ce=(0,r.useCallback)((function(e){e.stopPropagation()}),[]),Se=(0,r.useMemo)((function(){return function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},n=e.refKey,t=void 0===n?"ref":n,r=e.onChange,o=e.onClick,i=se(e,te);return ue(ue({},le({accept:E,multiple:u,type:"file",style:{display:"none"},onChange:je(U(r,be)),onClick:je(U(o,Ce)),tabIndex:-1},t,P)),i)}}),[P,t,u,be,o]);return ue(ue({},L),{},{isFocused:Z&&!o,getRootProps:ke,getInputProps:Se,rootRef:z,inputRef:P,open:je(he)})}(se(e,X)),i=o.open,a=se(o,ee);return(0,r.useImperativeHandle)(n,(function(){return{open:i}}),[i]),r.createElement(r.Fragment,null,t(ue(ue({},a),{},{open:i})))}));fe.displayName="Dropzone";var pe={disabled:!1,getFilesFromEvent:function(e){return(0,a.mG)(this,void 0,void 0,(function(){return(0,a.Jh)(this,(function(n){return s(e)&&s(e.dataTransfer)?[2,d(e.dataTransfer,e.type)]:function(e){return s(e)&&s(e.target)}(e)?[2,f(e)]:Array.isArray(e)&&e.every((function(e){return"getFile"in e&&"function"===typeof e.getFile}))?[2,p(e)]:[2,[]]}))}))},maxSize:1/0,minSize:0,multiple:!0,maxFiles:0,preventDropOnDocument:!0,noClick:!1,noKeyboard:!1,noDrag:!1,noDragEventsBubbling:!1,validator:null,useFsAccessApi:!0,autoFocus:!1};fe.defaultProps=pe,fe.propTypes={children:i().func,accept:i().objectOf(i().arrayOf(i().string)),multiple:i().bool,preventDropOnDocument:i().bool,noClick:i().bool,noKeyboard:i().bool,noDrag:i().bool,noDragEventsBubbling:i().bool,minSize:i().number,maxSize:i().number,maxFiles:i().number,disabled:i().bool,getFilesFromEvent:i().func,onFileDialogCancel:i().func,onFileDialogOpen:i().func,useFsAccessApi:i().bool,autoFocus:i().bool,onDragEnter:i().func,onDragLeave:i().func,onDragOver:i().func,onDrop:i().func,onDropAccepted:i().func,onDropRejected:i().func,onError:i().func,validator:i().func};var de=fe,ve={isFocused:!1,isFileDialogActive:!1,isDragActive:!1,isDragAccept:!1,isDragReject:!1,acceptedFiles:[],fileRejections:[]};function me(e,n){switch(n.type){case"focus":return ue(ue({},e),{},{isFocused:!0});case"blur":return ue(ue({},e),{},{isFocused:!1});case"openDialog":return ue(ue({},ve),{},{isFileDialogActive:!0});case"closeDialog":return ue(ue({},e),{},{isFileDialogActive:!1});case"setDraggedFiles":return ue(ue({},e),{},{isDragActive:n.isDragActive,isDragAccept:n.isDragAccept,isDragReject:n.isDragReject});case"setFiles":return ue(ue({},e),{},{acceptedFiles:n.acceptedFiles,fileRejections:n.fileRejections});case"reset":return ue({},ve);default:return e}}function ge(){}}}]);
//# sourceMappingURL=174.fd0ae4e2.chunk.js.map