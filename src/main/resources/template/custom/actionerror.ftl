<#if (actionErrors?exists && actionErrors?size > 0)>
<div <#rt/>
<#if parameters.id?if_exists != "">
 id="${parameters.id?html}"<#rt/>
<#else>
 id="actionError"<#rt/>
</#if>

<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
<#else>
 class="alert alert-danger"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
>
<#list actionErrors as message>
	<span>${message}</span>
	<#if message_has_next><br/><#rt/></#if>
</#list>
&nbsp;&nbsp;[<a href="#" onclick="javascript:
<#if parameters.id?if_exists != "">
 jQuery('#${parameters.id?html}')<#rt/>
<#else>
 jQuery('#actionError')<#rt/>
</#if>
.hide();return false;">hide</a>]</div><#rt/>
</#if>