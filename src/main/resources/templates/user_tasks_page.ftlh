<#include "base.ftlh">
<#import "spring.ftl" as spring>
<#macro title>Success!</#macro>
<#macro content>
<h1>My tasks</h1>
<#list tasks as task>
    <form action="/profile/tasks/${task.id}" method="post">
        <h1>${task.title}</h1>
        <p>${task.description}</p>
        <p>${task.reward}</p>
        <p>
            <input type="submit" value="Завершить">
        </p>
    </form>
</#list>
<h1>
    <p><a href="/tasks">Другие задачи</a></p>
</h1>
</#macro>