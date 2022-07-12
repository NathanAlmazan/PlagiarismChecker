"use strict";(self.webpackChunkplagiarism=self.webpackChunkplagiarism||[]).push([[593],{7921:function(n,e,s){var t=s(6871),i=s(3767),a=s(1889),o=s(890),l=s(6151),r=s(3400),c=s(7394),u=s(4696),d=s(184);e.Z=function(n){var e=n.buttonText,s=n.title,f=n.subtitle,m=n.back,h=n.buttonClick,g=(0,t.s0)();return(0,d.jsxs)(a.ZP,{container:!0,justifyContent:"space-between",alignItems:"center",children:[(0,d.jsx)(a.ZP,{item:!0,children:(0,d.jsxs)(i.Z,{direction:"row",spacing:1,children:[m&&(0,d.jsx)(r.Z,{onClick:function(){return g(-1)},children:(0,d.jsx)(c.Z,{})}),(0,d.jsxs)(i.Z,{direction:"column",children:[(0,d.jsx)(o.Z,{variant:"h3",component:"h3",gutterBottom:!0,children:s}),(0,d.jsx)(o.Z,{variant:"subtitle2",children:f})]})]})}),(0,d.jsx)(a.ZP,{item:!0,children:(0,d.jsx)(l.Z,{sx:{mt:{xs:2,md:0}},variant:"contained",startIcon:(0,d.jsx)(u.Z,{fontSize:"small"}),onClick:h,children:e})})]})}},8418:function(n,e,s){var t=s(6934),i=s(4554),a=s(1614),o=s(184),l=(0,t.ZP)(i.Z)((function(n){var e=n.theme;return"\n        padding: ".concat(e.spacing(4),";\n")}));e.Z=function(n){var e=n.children;return(0,o.jsx)(l,{className:"MuiPageTitle-wrapper",children:(0,o.jsx)(a.Z,{maxWidth:"lg",children:e})})}},9593:function(n,e,s){s.r(e);var t=s(885),i=s(2791),a=s(6871),o=s(6907),l=s(1614),r=s(8418),c=s(7921),u=s(4384),d=s(8297),f=s(307),m=s(184),h=i.lazy((function(){return s.e(669).then(s.bind(s,1669))})),g=i.lazy((function(){return Promise.all([s.e(346),s.e(843)]).then(s.bind(s,4843))})),x=i.lazy((function(){return Promise.all([s.e(346),s.e(326),s.e(908)]).then(s.bind(s,908))})),j=i.lazy((function(){return Promise.all([s.e(915),s.e(254),s.e(89)]).then(s.bind(s,4089))})),v=i.lazy((function(){return Promise.all([s.e(646),s.e(824)]).then(s.bind(s,7824))}));e.default=function(){var n=(0,a.UO)().classCode,e=(0,f.a)().user,s=(0,a.s0)(),Z=(0,i.useState)(),b=(0,t.Z)(Z,2),p=b[0],C=b[1],T=(0,i.useState)(),k=(0,t.Z)(T,2),I=k[0],w=k[1],y=(0,i.useState)(),A=(0,t.Z)(y,2),P=A[0],S=A[1],z=(0,i.useState)(!1),F=(0,t.Z)(z,2),B=F[0],H=F[1],M=(0,i.useState)(null),N=(0,t.Z)(M,2),D=N[0],E=N[1],L=(0,i.useRef)(null);return(0,i.useEffect)((function(){e?e.teacher||s("/student/app"):s("/")}),[e,s]),(0,i.useEffect)((function(){n&&(0,u.nk)(n).then((function(n){C(n),w(n.assignments[0])})).catch((function(n){return console.log(n)}))}),[n]),(0,m.jsxs)(m.Fragment,{children:[(0,m.jsx)(o.ql,{children:(0,m.jsx)("title",{children:p?p.classroomName:"Class Dashboard"})}),(0,m.jsx)(r.Z,{children:(0,m.jsx)(c.Z,{title:p?p.classroomName:"Class Dashboard",subtitle:"View and manage your classroom's tasks.",buttonText:"Add Assignment",buttonClick:function(){return H(!0)},back:!0})}),(0,m.jsx)(l.Z,{children:p?(0,m.jsxs)(m.Fragment,{children:[(0,m.jsx)(g,{assignments:p.assignments,selected:I&&I.assignmentId,selectAssign:function(n){w(n),L.current&&window.scrollTo({top:L.current.offsetTop,behavior:"smooth"})},editAssign:function(n){return S(n)},deleteAssign:function(e){n&&(0,d.re)(e,n).then((function(n){C(n),E("Successfully deleted assignment")})).catch((function(n){return console.log(n)}))},classCode:n}),(0,m.jsx)("div",{ref:L}),p.assignments.length>0&&(0,m.jsx)(x,{assignmentTitle:I?I.assignTitle:p.assignments[0].assignTitle,submittedFiles:I?I.submittedFiles:p.assignments[0].submittedFiles,classCode:p.classroomCode,assignId:I?I.assignmentId:p.assignments[0].assignmentId})]}):(0,m.jsx)(h,{open:void 0===p})}),(0,m.jsx)(j,{open:B,handleClose:function(){return H(!1)},saveAssignment:function(n){p&&(H(!1),(0,d.IO)(n,p.classroomId,p.classroomCode).then((function(e){C(e),w(e.assignments.find((function(e){return e.assignTitle===n.assignTitle}))),E("Successfully added "+n.assignTitle)})).catch((function(n){return console.log(n)})))}}),(0,m.jsx)(j,{open:void 0!==P,assignment:P,handleClose:function(){return S(void 0)},saveAssignment:function(n){p&&P&&(n.assignmentId=P.assignmentId,S(void 0),(0,d.BG)(n,p.classroomId,p.classroomCode).then((function(e){C(e),w(e.assignments.find((function(e){return e.assignTitle===n.assignTitle}))),E("Successfully updated "+n.assignTitle)})).catch((function(n){return console.log(n)})))}}),(0,m.jsx)(v,{open:null!==D,message:D,handleClose:function(){return E(null)}})]})}},4696:function(n,e,s){var t=s(5318);e.Z=void 0;var i=t(s(5649)),a=s(184),o=(0,i.default)((0,a.jsx)("path",{d:"M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"}),"AddTwoTone");e.Z=o},7394:function(n,e,s){var t=s(5318);e.Z=void 0;var i=t(s(5649)),a=s(184),o=(0,i.default)((0,a.jsx)("path",{d:"M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"}),"ArrowBack");e.Z=o}}]);
//# sourceMappingURL=593.c062a0d6.chunk.js.map