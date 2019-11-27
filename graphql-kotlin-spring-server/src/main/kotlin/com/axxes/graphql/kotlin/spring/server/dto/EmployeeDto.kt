package com.axxes.graphql.kotlin.spring.server.dto

data class EmployeeDto(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val email: String,
        val competenceCenters: List<CompetenceCenterDto>
)

enum class CompetenceCenterDto {
    JAVA, DOTNET, FRONTEND, TESTING, INFRA
}