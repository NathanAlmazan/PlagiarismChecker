"use strict";(self.webpackChunkplagiarism=self.webpackChunkplagiarism||[]).push([[197],{7921:function(n,e,t){var u=t(6871),s=t(3767),c=t(1889),o=t(890),r=t(6151),i=t(3400),l=t(7394),a=t(4696),d=t(184);e.Z=function(n){var e=n.buttonText,t=n.title,f=n.subtitle,h=n.back,j=n.buttonClick,b=(0,u.s0)();return(0,d.jsxs)(c.ZP,{container:!0,justifyContent:"space-between",alignItems:"center",children:[(0,d.jsx)(c.ZP,{item:!0,children:(0,d.jsxs)(s.Z,{direction:"row",spacing:1,children:[h&&(0,d.jsx)(i.Z,{onClick:function(){return b(-1)},children:(0,d.jsx)(l.Z,{})}),(0,d.jsxs)(s.Z,{direction:"column",children:[(0,d.jsx)(o.Z,{variant:"h3",component:"h3",gutterBottom:!0,children:t}),(0,d.jsx)(o.Z,{variant:"subtitle2",children:f})]})]})}),(0,d.jsx)(c.ZP,{item:!0,children:(0,d.jsx)(r.Z,{sx:{mt:{xs:2,md:0}},variant:"contained",startIcon:(0,d.jsx)(a.Z,{fontSize:"small"}),onClick:j,children:e})})]})}},8418:function(n,e,t){var u=t(6934),s=t(4554),c=t(1614),o=t(184),r=(0,u.ZP)(s.Z)((function(n){var e=n.theme;return"\n        padding: ".concat(e.spacing(4),";\n")}));e.Z=function(n){var e=n.children;return(0,o.jsx)(r,{className:"MuiPageTitle-wrapper",children:(0,o.jsx)(c.Z,{maxWidth:"lg",children:e})})}},3197:function(n,e,t){t.r(e);var u=t(885),s=t(2791),c=t(6871),o=t(6907),r=t(8418),i=t(7921),l=t(1614),a=t(4384),d=t(8297),f=t(1856),h=t(7349),j=t(307),b=t(184),x=s.lazy((function(){return t.e(876).then(t.bind(t,6876))})),m=s.lazy((function(){return t.e(680).then(t.bind(t,2680))})),v=s.lazy((function(){return t.e(867).then(t.bind(t,867))})),p=s.lazy((function(){return t.e(10).then(t.bind(t,2010))})),Z=s.lazy((function(){return Promise.all([t.e(646),t.e(824)]).then(t.bind(t,7824))})),g=s.lazy((function(){return t.e(669).then(t.bind(t,1669))})),S=s.lazy((function(){return t.e(875).then(t.bind(t,875))}));e.default=function(){var n=(0,j.a)().user,e=(0,c.s0)(),t=(0,s.useState)(0),y=(0,u.Z)(t,2),C=y[0],I=y[1],w=(0,s.useState)([]),T=(0,u.Z)(w,2),k=T[0],z=T[1],P=(0,s.useState)(),D=(0,u.Z)(P,2),N=D[0],E=D[1],M=(0,s.useState)(!1),V=(0,u.Z)(M,2),B=V[0],H=V[1],L=(0,s.useState)(!1),A=(0,u.Z)(L,2),G=A[0],q=A[1],F=(0,s.useState)(!1),R=(0,u.Z)(F,2),W=R[0],J=R[1],K=(0,s.useState)(null),O=(0,u.Z)(K,2),Q=O[0],U=O[1],X=(0,s.useState)(null),Y=(0,u.Z)(X,2),$=Y[0],_=Y[1],nn=(0,s.useState)(null),en=(0,u.Z)(nn,2),tn=en[0],un=en[1],sn=(0,s.useState)(null),cn=(0,u.Z)(sn,2),on=cn[0],rn=cn[1],ln=(0,s.useRef)(null);return(0,s.useEffect)((function(){J((function(n){return!0})),n?n.teacher?I((function(e){return n.teacher})):e("/student/app"):e("/")}),[n,e]),(0,s.useEffect)((function(){0===k.length&&(0,a.xN)(C).then((function(n){z((function(e){return n})),E((function(e){return n[0]})),J((function(n){return!1}))})).catch((function(n){return console.log(n.message)}))}),[C,k]),(0,b.jsxs)(b.Fragment,{children:[(0,b.jsx)(o.ql,{children:(0,b.jsx)("title",{children:"Teacher Dashboard"})}),(0,b.jsx)(r.Z,{children:(0,b.jsx)(i.Z,{title:n?"Good Day, "+n.account.firstName:"Good Day",subtitle:"View and manage your subjects and classrooms",buttonText:"Create Classroom",buttonClick:function(){return q(!0)}})}),(0,b.jsxs)(l.Z,{children:[(0,b.jsx)(x,{subjectList:k,selectSubject:function(n){E(k.find((function(e){return e.subjectId===n}))),ln.current&&window.scrollTo({top:ln.current.offsetTop,behavior:"smooth"})},addSubject:function(){return H(!0)},editSubject:function(n){return U(n)},deleteSubject:function(n){(0,d.Pl)(n,C).then((function(n){z(n),E(n[0]),un("Subject was deleted sucessfully.")})).catch((function(n){return rn("Cannot Delete Subject:"+n.response.data.errors[0])}))},selectedSub:N&&N.subjectId}),(0,b.jsxs)(f.M,{exitBeforeEnter:!0,children:[(0,b.jsx)("div",{ref:ln}),N&&(0,b.jsx)(h.E.div,{initial:{opacity:0,y:80},animate:{opacity:1,y:0},exit:{opacity:0,y:80},transition:{duration:.5},children:(0,b.jsx)(m,{classrooms:N.classrooms,subject:N.subjectTitle,editClassroom:function(n){return _(n)},delteClassroom:function(n){(0,d.so)(n,C).then((function(n){if(z(n),N){var e=n.find((function(n){return n.subjectId===(null===N||void 0===N?void 0:N.subjectId)}));e&&E(e)}else E(n[0]);un("Classroom was deleted sucessfully.")})).catch((function(n){(0,a.xN)(C).then((function(n){if(z(n),N){var e=n.find((function(n){return n.subjectId===(null===N||void 0===N?void 0:N.subjectId)}));e&&E(e)}else E(n[0]);un("Classroom was deleted sucessfully.")}))}))}})},N.subjectId)]})]}),(0,b.jsx)(v,{open:B,handleClose:function(){return H(!1)},saveSubject:function(n,e){J(!0),H(!1),(0,d.Tm)(n,e,C).then((function(e){z(e),J(!1),un("Successfully added "+n)})).catch((function(n){return console.log(n.message)}))}}),(0,b.jsx)(v,{open:null!==Q,subject:Q,handleClose:function(){return U(null)},saveSubject:function(n,e){Q&&(U(null),(0,d.Vk)(n,e,Q.subjectId,C).then((function(e){z(e);var t=e.find((function(n){return n.subjectId===Q.subjectId}));t&&E(t),un("Sucessfully updated "+n)})).catch((function(n){return console.log(n.message)})))}}),(0,b.jsx)(p,{open:G,options:k.map((function(n){return{id:n.subjectId.toString(),label:n.subjectTitle}})),handleClose:function(){return q(!1)},saveClass:function(n,e){J(!0),q(!1),(0,d.DN)(n,e,C).then((function(t){z(t),J(!1),un("Successfully added "+e);var u=t.find((function(e){return e.subjectId===n}));u&&E(u)})).catch((function(n){return console.log(n.message)}))}}),(0,b.jsx)(p,{open:null!==$,classInfo:$,subject:N&&N.subjectId,options:k.map((function(n){return{id:n.subjectId.toString(),label:n.subjectTitle}})),handleClose:function(){return _(null)},saveClass:function(n,e){$&&(_(null),(0,d.Vh)($.classroomId,e,n,C).then((function(t){z(t);var u=t.find((function(e){return e.subjectId===n}));u&&E(u),un("Sucessfully updated "+e)})).catch((function(n){return console.log(n.message)})))}}),(0,b.jsx)(g,{open:W}),(0,b.jsx)(S,{open:null!==on,message:on,handleClose:function(){return rn(null)}}),(0,b.jsx)(Z,{open:null!==tn,message:tn,handleClose:function(){return un(null)}})]})}},4696:function(n,e,t){var u=t(5318);e.Z=void 0;var s=u(t(5649)),c=t(184),o=(0,s.default)((0,c.jsx)("path",{d:"M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"}),"AddTwoTone");e.Z=o},7394:function(n,e,t){var u=t(5318);e.Z=void 0;var s=u(t(5649)),c=t(184),o=(0,s.default)((0,c.jsx)("path",{d:"M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"}),"ArrowBack");e.Z=o}}]);
//# sourceMappingURL=197.cb050288.chunk.js.map