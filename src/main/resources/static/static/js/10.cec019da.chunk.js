"use strict";(self.webpackChunkplagiarism=self.webpackChunkplagiarism||[]).push([[10],{2010:function(e,t,a){a.r(t),a.d(t,{default:function(){return Z}});var n=a(1413),o=a(885),r=a(2791),i=a(6151),s=a(7391),c=a(5574),l=a(7123),d=a(9157),u=a(1691),p=a(5661),v=a(9321),m=a(5022),f=a(184);function Z(e){var t=e.open,a=e.options,Z=e.classInfo,g=e.subject,b=e.handleClose,h=e.saveClass,x=(0,r.useState)({subjectId:"",className:""}),y=(0,o.Z)(x,2),C=y[0],j=y[1],S=C.subjectId,I=C.className;(0,r.useEffect)((function(){Z&&g&&j({subjectId:g.toString(),className:Z.classroomName})}),[Z,g]);return(0,f.jsx)(c.Z,{open:t,onClose:b,children:(0,f.jsxs)("form",{onSubmit:function(e){e.preventDefault(),h(parseInt(S),I),j({subjectId:"",className:""})},children:[(0,f.jsx)(p.Z,{children:Z?"Edit Classroom":"Create Classroom"}),(0,f.jsxs)(d.Z,{children:[(0,f.jsx)(u.Z,{children:Z?"Editinng the classroom information will not affect its content. Click save to save changes.":"To create a classroom, please provide the name and select the its subject."}),(0,f.jsx)(s.Z,{autoFocus:!0,name:"className",label:"Class Name",fullWidth:!0,variant:"standard",value:I,onChange:function(e){j((0,n.Z)((0,n.Z)({},C),{},{className:e.target.value}))},inputProps:{maxLength:20},required:!0,sx:{mt:2}}),(0,f.jsx)(v.Z,{label:"Subject",fullWidth:!0,variant:"standard",value:S,onChange:function(e){j((0,n.Z)((0,n.Z)({},C),{},{subjectId:e.target.value}))},required:!0,sx:{mt:2},children:a.map((function(e){return(0,f.jsx)(m.Z,{value:e.id,children:e.label},e.id)}))})]}),(0,f.jsxs)(l.Z,{children:[(0,f.jsx)(i.Z,{onClick:b,children:"Cancel"}),(0,f.jsx)(i.Z,{type:"submit",children:"Save"})]})]})})}},7123:function(e,t,a){a.d(t,{Z:function(){return f}});var n=a(3366),o=a(7462),r=a(2791),i=a(8182),s=a(4419),c=a(6934),l=a(1402),d=a(1217);function u(e){return(0,d.Z)("MuiDialogActions",e)}(0,a(5878).Z)("MuiDialogActions",["root","spacing"]);var p=a(184),v=["className","disableSpacing"],m=(0,c.ZP)("div",{name:"MuiDialogActions",slot:"Root",overridesResolver:function(e,t){var a=e.ownerState;return[t.root,!a.disableSpacing&&t.spacing]}})((function(e){var t=e.ownerState;return(0,o.Z)({display:"flex",alignItems:"center",padding:8,justifyContent:"flex-end",flex:"0 0 auto"},!t.disableSpacing&&{"& > :not(:first-of-type)":{marginLeft:8}})})),f=r.forwardRef((function(e,t){var a=(0,l.Z)({props:e,name:"MuiDialogActions"}),r=a.className,c=a.disableSpacing,d=void 0!==c&&c,f=(0,n.Z)(a,v),Z=(0,o.Z)({},a,{disableSpacing:d}),g=function(e){var t=e.classes,a={root:["root",!e.disableSpacing&&"spacing"]};return(0,s.Z)(a,u,t)}(Z);return(0,p.jsx)(m,(0,o.Z)({className:(0,i.Z)(g.root,r),ownerState:Z,ref:t},f))}))},1691:function(e,t,a){a.d(t,{Z:function(){return f}});var n=a(3366),o=a(7462),r=a(2791),i=a(4419),s=a(6934),c=a(1402),l=a(890),d=a(1217);function u(e){return(0,d.Z)("MuiDialogContentText",e)}(0,a(5878).Z)("MuiDialogContentText",["root"]);var p=a(184),v=["children"],m=(0,s.ZP)(l.Z,{shouldForwardProp:function(e){return(0,s.FO)(e)||"classes"===e},name:"MuiDialogContentText",slot:"Root",overridesResolver:function(e,t){return t.root}})({}),f=r.forwardRef((function(e,t){var a=(0,c.Z)({props:e,name:"MuiDialogContentText"}),r=(0,n.Z)(a,v),s=function(e){var t=e.classes,a=(0,i.Z)({root:["root"]},u,t);return(0,o.Z)({},t,a)}(r);return(0,p.jsx)(m,(0,o.Z)({component:"p",variant:"body1",color:"text.secondary",ref:t,ownerState:r},a,{classes:s}))}))},5022:function(e,t,a){a.d(t,{Z:function(){return w}});var n=a(4942),o=a(3366),r=a(7462),i=a(2791),s=a(8182),c=a(4419),l=a(2065),d=a(6934),u=a(1402),p=a(6199),v=a(7479),m=a(162),f=a(2071),Z=a(133),g=a(5878);var b=(0,g.Z)("MuiListItemIcon",["root","alignItemsFlexStart"]),h=a(9849),x=a(1217);function y(e){return(0,x.Z)("MuiMenuItem",e)}var C=(0,g.Z)("MuiMenuItem",["root","focusVisible","dense","disabled","divider","gutters","selected"]),j=a(184),S=["autoFocus","component","dense","divider","disableGutters","focusVisibleClassName","role","tabIndex"],I=(0,d.ZP)(v.Z,{shouldForwardProp:function(e){return(0,d.FO)(e)||"classes"===e},name:"MuiMenuItem",slot:"Root",overridesResolver:function(e,t){var a=e.ownerState;return[t.root,a.dense&&t.dense,a.divider&&t.divider,!a.disableGutters&&t.gutters]}})((function(e){var t,a=e.theme,o=e.ownerState;return(0,r.Z)({},a.typography.body1,{display:"flex",justifyContent:"flex-start",alignItems:"center",position:"relative",textDecoration:"none",minHeight:48,paddingTop:6,paddingBottom:6,boxSizing:"border-box",whiteSpace:"nowrap"},!o.disableGutters&&{paddingLeft:16,paddingRight:16},o.divider&&{borderBottom:"1px solid ".concat((a.vars||a).palette.divider),backgroundClip:"padding-box"},(t={"&:hover":{textDecoration:"none",backgroundColor:(a.vars||a).palette.action.hover,"@media (hover: none)":{backgroundColor:"transparent"}}},(0,n.Z)(t,"&.".concat(C.selected),(0,n.Z)({backgroundColor:a.vars?"rgba(".concat(a.vars.palette.primary.mainChannel," / ").concat(a.vars.palette.action.selectedOpacity,")"):(0,l.Fq)(a.palette.primary.main,a.palette.action.selectedOpacity)},"&.".concat(C.focusVisible),{backgroundColor:a.vars?"rgba(".concat(a.vars.palette.primary.mainChannel," / calc(").concat(a.vars.palette.action.selectedOpacity," + ").concat(a.vars.palette.action.focusOpacity,"))"):(0,l.Fq)(a.palette.primary.main,a.palette.action.selectedOpacity+a.palette.action.focusOpacity)})),(0,n.Z)(t,"&.".concat(C.selected,":hover"),{backgroundColor:a.vars?"rgba(".concat(a.vars.palette.primary.mainChannel," / calc(").concat(a.vars.palette.action.selectedOpacity," + ").concat(a.vars.palette.action.hoverOpacity,"))"):(0,l.Fq)(a.palette.primary.main,a.palette.action.selectedOpacity+a.palette.action.hoverOpacity),"@media (hover: none)":{backgroundColor:a.vars?"rgba(".concat(a.vars.palette.primary.mainChannel," / ").concat(a.vars.palette.action.selectedOpacity,")"):(0,l.Fq)(a.palette.primary.main,a.palette.action.selectedOpacity)}}),(0,n.Z)(t,"&.".concat(C.focusVisible),{backgroundColor:(a.vars||a).palette.action.focus}),(0,n.Z)(t,"&.".concat(C.disabled),{opacity:(a.vars||a).palette.action.disabledOpacity}),(0,n.Z)(t,"& + .".concat(Z.Z.root),{marginTop:a.spacing(1),marginBottom:a.spacing(1)}),(0,n.Z)(t,"& + .".concat(Z.Z.inset),{marginLeft:52}),(0,n.Z)(t,"& .".concat(h.Z.root),{marginTop:0,marginBottom:0}),(0,n.Z)(t,"& .".concat(h.Z.inset),{paddingLeft:36}),(0,n.Z)(t,"& .".concat(b.root),{minWidth:36}),t),!o.dense&&(0,n.Z)({},a.breakpoints.up("sm"),{minHeight:"auto"}),o.dense&&(0,r.Z)({minHeight:32,paddingTop:4,paddingBottom:4},a.typography.body2,(0,n.Z)({},"& .".concat(b.root," svg"),{fontSize:"1.25rem"})))})),w=i.forwardRef((function(e,t){var a=(0,u.Z)({props:e,name:"MuiMenuItem"}),n=a.autoFocus,l=void 0!==n&&n,d=a.component,v=void 0===d?"li":d,Z=a.dense,g=void 0!==Z&&Z,b=a.divider,h=void 0!==b&&b,x=a.disableGutters,C=void 0!==x&&x,w=a.focusVisibleClassName,M=a.role,k=void 0===M?"menuitem":M,O=a.tabIndex,N=(0,o.Z)(a,S),F=i.useContext(p.Z),D={dense:g||F.dense||!1,disableGutters:C},R=i.useRef(null);(0,m.Z)((function(){l&&R.current&&R.current.focus()}),[l]);var T,G=(0,r.Z)({},a,{dense:D.dense,divider:h,disableGutters:C}),P=function(e){var t=e.disabled,a=e.dense,n=e.divider,o=e.disableGutters,i=e.selected,s=e.classes,l={root:["root",a&&"dense",t&&"disabled",!o&&"gutters",n&&"divider",i&&"selected"]},d=(0,c.Z)(l,y,s);return(0,r.Z)({},s,d)}(a),V=(0,f.Z)(R,t);return a.disabled||(T=void 0!==O?O:-1),(0,j.jsx)(p.Z.Provider,{value:D,children:(0,j.jsx)(I,(0,r.Z)({ref:V,role:k,tabIndex:T,component:v,focusVisibleClassName:(0,s.Z)(P.focusVisible,w)},N,{ownerState:G,classes:P}))})}))}}]);
//# sourceMappingURL=10.cec019da.chunk.js.map