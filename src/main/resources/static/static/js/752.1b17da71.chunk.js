"use strict";(self.webpackChunkplagiarism=self.webpackChunkplagiarism||[]).push([[752],{3401:function(t,e,n){var i=n(6871),a=n(3767),r=n(890),s=n(3400),o=n(7394),c=n(184);e.Z=function(t){var e=(0,i.s0)();return(0,c.jsxs)(a.Z,{direction:"row",spacing:1,children:[t.back&&(0,c.jsx)(s.Z,{onClick:function(){return e(-1)},children:(0,c.jsx)(o.Z,{})}),(0,c.jsxs)(a.Z,{direction:"column",children:[(0,c.jsx)(r.Z,{variant:"h3",component:"h3",gutterBottom:!0,children:t.title}),(0,c.jsx)(r.Z,{variant:"subtitle2",children:t.subtitle})]})]})}},8418:function(t,e,n){var i=n(6934),a=n(4554),r=n(1614),s=n(184),o=(0,i.ZP)(a.Z)((function(t){var e=t.theme;return"\n        padding: ".concat(e.spacing(4),";\n")}));e.Z=function(t){var e=t.children;return(0,s.jsx)(o,{className:"MuiPageTitle-wrapper",children:(0,s.jsx)(r.Z,{maxWidth:"lg",children:e})})}},2752:function(t,e,n){n.r(e);var i=n(885),a=n(2791),r=n(6871),s=n(6907),o=n(1614),c=n(8418),u=n(3401),d=n(4384),l=n(307),m=n(184),f=a.lazy((function(){return n.e(669).then(n.bind(n,1669))})),h=a.lazy((function(){return Promise.all([n.e(346),n.e(843)]).then(n.bind(n,4843))}));e.default=function(){var t=(0,l.a)().user,e=(0,r.s0)(),n=(0,r.UO)().classCode,x=(0,a.useState)(),p=(0,i.Z)(x,2),v=p[0],Z=p[1],b=(0,a.useState)(),g=(0,i.Z)(b,2),k=g[0],j=g[1],W=(0,a.useRef)(null),w=(0,a.useState)([]),S=(0,i.Z)(w,2),C=S[0],G=S[1];return(0,a.useEffect)((function(){n&&(0,d.nk)(n).then((function(t){Z(t),j(t.assignments[0])})).catch((function(t){return console.log(t)}))}),[n]),(0,a.useEffect)((function(){if(t)if(t.student){var n=t.student;(0,d._O)(n).then((function(t){G((function(e){return t}))})).catch((function(t){return console.log(t.message)}))}else e("/teacher/app")}),[t,e]),(0,m.jsxs)(m.Fragment,{children:[(0,m.jsx)(s.ql,{children:(0,m.jsx)("title",{children:v?v.classroomName:"Class Dashboard"})}),(0,m.jsx)(c.Z,{children:(0,m.jsx)(u.Z,{title:v?v.classroomName:"Class Dashboard",subtitle:"View and manage your classroom's tasks.",back:!0})}),(0,m.jsx)(o.Z,{children:v?(0,m.jsx)(m.Fragment,{children:(0,m.jsx)(h,{assignments:v.assignments,selected:k&&k.assignmentId,selectAssign:function(t){j(t),W.current&&window.scrollTo({top:W.current.offsetTop,behavior:"smooth"})},classCode:n,submitted:C})}):(0,m.jsx)(f,{open:void 0===v})})]})}},7394:function(t,e,n){var i=n(5318);e.Z=void 0;var a=i(n(5649)),r=n(184),s=(0,a.default)((0,r.jsx)("path",{d:"M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"}),"ArrowBack");e.Z=s},1614:function(t,e,n){n.d(e,{Z:function(){return w}});var i=n(4942),a=n(3366),r=n(7462),s=n(2791),o=n(8182),c=n(7312),u=n(1217),d=n(4419),l=n(6083),m=(0,n(4046).ZP)(),f=n(5080),h=n(184),x=["className","component","disableGutters","fixed","maxWidth","classes"],p=(0,f.Z)(),v=m("div",{name:"MuiContainer",slot:"Root",overridesResolver:function(t,e){var n=t.ownerState;return[e.root,e["maxWidth".concat((0,c.Z)(String(n.maxWidth)))],n.fixed&&e.fixed,n.disableGutters&&e.disableGutters]}}),Z=function(t){return(0,l.Z)({props:t,name:"MuiContainer",defaultTheme:p})},b=function(t,e){var n=t.classes,i=t.fixed,a=t.disableGutters,r=t.maxWidth,s={root:["root",r&&"maxWidth".concat((0,c.Z)(String(r))),i&&"fixed",a&&"disableGutters"]};return(0,d.Z)(s,(function(t){return(0,u.Z)(e,t)}),n)};var g=n(4036),k=n(6934),j=n(1402),W=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=t.createStyledComponent,n=void 0===e?v:e,c=t.useThemeProps,u=void 0===c?Z:c,d=t.componentName,l=void 0===d?"MuiContainer":d,m=n((function(t){var e=t.theme,n=t.ownerState;return(0,r.Z)({width:"100%",marginLeft:"auto",boxSizing:"border-box",marginRight:"auto",display:"block"},!n.disableGutters&&(0,i.Z)({paddingLeft:e.spacing(2),paddingRight:e.spacing(2)},e.breakpoints.up("sm"),{paddingLeft:e.spacing(3),paddingRight:e.spacing(3)}))}),(function(t){var e=t.theme;return t.ownerState.fixed&&Object.keys(e.breakpoints.values).reduce((function(t,n){var i=n,a=e.breakpoints.values[i];return 0!==a&&(t[e.breakpoints.up(i)]={maxWidth:"".concat(a).concat(e.breakpoints.unit)}),t}),{})}),(function(t){var e=t.theme,n=t.ownerState;return(0,r.Z)({},"xs"===n.maxWidth&&(0,i.Z)({},e.breakpoints.up("xs"),{maxWidth:Math.max(e.breakpoints.values.xs,444)}),n.maxWidth&&"xs"!==n.maxWidth&&(0,i.Z)({},e.breakpoints.up(n.maxWidth),{maxWidth:"".concat(e.breakpoints.values[n.maxWidth]).concat(e.breakpoints.unit)}))})),f=s.forwardRef((function(t,e){var n=u(t),i=n.className,s=n.component,c=void 0===s?"div":s,d=n.disableGutters,f=void 0!==d&&d,p=n.fixed,v=void 0!==p&&p,Z=n.maxWidth,g=void 0===Z?"lg":Z,k=(0,a.Z)(n,x),j=(0,r.Z)({},n,{component:c,disableGutters:f,fixed:v,maxWidth:g}),W=b(j,l);return(0,h.jsx)(m,(0,r.Z)({as:c,ownerState:j,className:(0,o.Z)(W.root,i),ref:e},k))}));return f}({createStyledComponent:(0,k.ZP)("div",{name:"MuiContainer",slot:"Root",overridesResolver:function(t,e){var n=t.ownerState;return[e.root,e["maxWidth".concat((0,g.Z)(String(n.maxWidth)))],n.fixed&&e.fixed,n.disableGutters&&e.disableGutters]}}),useThemeProps:function(t){return(0,j.Z)({props:t,name:"MuiContainer"})}}),w=W}}]);
//# sourceMappingURL=752.1b17da71.chunk.js.map