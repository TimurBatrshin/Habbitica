<#include "base.ftlh">
<#import "spring.ftl" as spring>
<#macro title>Task</#macro>
<#macro content>
<h1>Tasks</h1>
<p><a href="/profile">Профиль</a></p>
<@spring.bind "taskForm"/>
<form action="/tasks/add" method="post">
    <#--    <input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>-->
    <@spring.formTextarea "taskForm.title" 'placeholder="title"'/>
    <@spring.formTextarea "taskForm.description" 'placeholder="description"'/>
    <@spring.formTextarea "taskForm.reward" 'placeholder="reward"'/>
    <input type="submit" value="Enter">
</form>
</#macro>