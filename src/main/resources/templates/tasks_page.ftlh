<#include "base.ftlh">
<#import "spring.ftl" as spring>
<#macro title>Task</#macro>
<#macro content>
    <h1>Tasks</h1>
    <p><a href="/profile">Профиль</a></p>
    <#list tasks as task>
        <form action="/tasks/${task.id}" method="post">
            <h1>${task.title}</h1>
            <p>${task.description}</p>
            <p>${task.reward}</p>
            <p>
                <input type="submit" value="Взять">
            </p>
        </form>
    </#list>
    <#if authority == 0>
        <p><a href="/tasks/add">Добавить задачи</a></p>
    </#if>
</#macro>