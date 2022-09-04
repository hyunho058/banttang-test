package com.hproject.banttang.report.entity;

import com.hproject.banttang.common.entity.BaseTimeEntity;
import com.hproject.banttang.report.entity.value.ReportCategory;
import com.hproject.banttang.report.entity.value.ReportTarget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private ReportTarget target;

    @Column(nullable = false, updatable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportCategory category;

    @Column(nullable = false)
    private String reportContent;

    @Column(nullable = false)
    private String actionContent;

    @Column(nullable = false, updatable = false)
    private Long reporterId;

    @Column
    private LocalDateTime completedAt;
}
