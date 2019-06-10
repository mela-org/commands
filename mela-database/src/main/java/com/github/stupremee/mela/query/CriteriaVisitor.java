package com.github.stupremee.mela.query;

import com.github.stupremee.mela.query.criterias.EqualsCriteria;
import com.github.stupremee.mela.query.criterias.GreaterThanCriteria;
import com.github.stupremee.mela.query.criterias.GreaterThanOrEqualCriteria;
import com.github.stupremee.mela.query.criterias.LessThanCriteria;
import com.github.stupremee.mela.query.criterias.LessThanOrEqualCriteria;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 10.06.19
 */
public interface CriteriaVisitor {

  void visitEquals(EqualsCriteria criteria);

  void visitLessThan(LessThanCriteria criteria);

  void visitLessThanOrEqual(LessThanOrEqualCriteria criteria);

  void visitGreaterThan(GreaterThanCriteria criteria);

  void visitGreaterThanOrEqual(GreaterThanOrEqualCriteria criteria);

}
