<#include "base.ftlh">
<#import "spring.ftl" as spring>
<#macro title>Profile</#macro>
<#macro content>
<h1>My achievements</h1>
<#list achievements as achievement>
    <form action="/profile/achievements" method="get">
        <h1>${achievement.title}</h1>
        <p>${achievement.description}</p>
    </form>
    <div class="back">
        <a href="/profile">Back to profile</a>
    </div>
</#list>
</#macro>